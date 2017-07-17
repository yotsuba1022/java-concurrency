package idv.java.ccr.future;

import java.util.concurrent.*;

/**
 * @author Carl Lu
 */
public class FutureDemo2 {

    private static final int MAX_TIME_LIMIT = 3;
    private static final ExecutorService laundryService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer response = null;
        try {
            boolean toWait = false;
            response = getResponse(toWait);
        } catch (TimeoutException e) {
            System.out.println("Time out.");
        }

        showResponse(response);
        laundryService.shutdown();
    }

    private static Integer getResponse(boolean toWait) throws ExecutionException, InterruptedException, TimeoutException {
        LaundryMachine laundryMachine = new LaundryMachine(10);
        System.out.println("Submitting laundry task...");

        Future<Integer> future = laundryService.submit(laundryMachine);

        System.out.println("Task is submitted");

        if (toWait) {
            int timer = 0;
            while (!future.isDone() && timer < MAX_TIME_LIMIT) {
                Thread.sleep(1600);
                timer++;
            }
        }

        // get() without params means blocking until the value return.
        return future.get(1, TimeUnit.SECONDS);
    }

    /*
    *
    * Notice that even if the task was timeout, we'll still get the response here, however,
    * the content of the response will be Null and the task will keep running until it finished.
    *
    * */
    private static void showResponse(Integer response) {
        System.out.println("Response received.");
        System.out.println("The result is: " + response);
    }

}
