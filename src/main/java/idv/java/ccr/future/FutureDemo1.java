package idv.java.ccr.future;

import java.util.concurrent.*;

/**
 * @author Carl Lu
 */
public class FutureDemo1 {

    private static final int MAX_TIME_LIMIT = 1;
    private static final ExecutorService LaundryService = Executors.newFixedThreadPool(1);

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        int timer = 0;
        LaundryMachine laundryMachine = new LaundryMachine(10);

        System.out.println("Submitting Task ...");

        Future future = LaundryService.submit(laundryMachine);

        System.out.println("Task is submitted");

        while (!future.isDone() && timer < MAX_TIME_LIMIT) {
            System.out.println("Task is not completed yet....");
            Thread.sleep(1);
            timer++;
        }

        System.out.println("I can't wait, let's check result");
        Integer result = null;
        try {
            result = (Integer) future.get(1, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            // Do nothing.
        }

        if (result == null) {
            System.out.println("Not yet done in time limit.");
        } else {
            System.out.println("Done with " + result + " cloths.");
        }

        LaundryService.shutdown();
    }

}
