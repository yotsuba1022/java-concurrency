package idv.java.ccr.jsr133.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author Carl Lu
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 4;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        boolean computable = ( end - start ) <= THRESHOLD;

        if (computable) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = ( start + end ) / 2;
            CountTask leftSubTask = new CountTask(start, middle);
            CountTask rightSubTask = new CountTask(middle + 1, end);

            leftSubTask.fork();
            rightSubTask.fork();

            int resultOfLeft = leftSubTask.join();
            int resultOfRight = rightSubTask.join();
            sum = resultOfLeft + resultOfRight;

            if (leftSubTask.isCompletedAbnormally()) {
                System.out.println(
                        "Left sub task completed abnormally, exception message: " + leftSubTask.getException().getMessage());
            }

            if (rightSubTask.isCompletedAbnormally()) {
                System.out.println(
                        "Right sub task completed abnormally, exception message: " + leftSubTask.getException().getMessage());
            }
        }

        return sum;
    }
}
