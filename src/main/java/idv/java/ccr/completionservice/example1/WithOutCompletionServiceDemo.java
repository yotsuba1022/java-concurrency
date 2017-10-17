package idv.java.ccr.completionservice.example1;

import idv.java.ccr.util.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Carl Lu
 */
public class WithOutCompletionServiceDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<String> worker1 = new Worker(ThreadColor.ANSI_CYAN);
        Callable<String> worker2 = new Worker(ThreadColor.ANSI_MAGENTA);
        Callable<String> worker3 = new Worker(ThreadColor.ANSI_YELLOW);
        Callable<String> worker4 = new Worker(ThreadColor.ANSI_BLUE);
        Callable<String> worker5 = new Worker(ThreadColor.ANSI_GREEN);

        Future f1 = executorService.submit(worker1);
        Future f2 = executorService.submit(worker2);
        Future f3 = executorService.submit(worker3);
        Future f4 = executorService.submit(worker4);
        Future f5 = executorService.submit(worker5);

        futures.add(f1);
        futures.add(f2);
        futures.add(f3);
        futures.add(f4);
        futures.add(f5);

        System.out.println("All done: " + checkIfAllTasksAreDone(futures));

        getBlocking(futures);

        System.out.println("All done: " + checkIfAllTasksAreDone(futures));

        executorService.shutdownNow();
    }

    private static void getBlocking(List<Future> futures) throws ExecutionException, InterruptedException {
        for (Future future : futures) {
            System.out.println(future.get());
        }
    }

    private static boolean checkIfAllTasksAreDone(List<Future> futures) {
        boolean allDone = true;
        for (Future future : futures) {
            allDone &= future.isDone();
        }
        return allDone;
    }

}
