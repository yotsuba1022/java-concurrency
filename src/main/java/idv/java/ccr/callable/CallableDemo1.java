package idv.java.ccr.callable;

import java.util.concurrent.*;

/**
 * @author Carl Lu
 */
public class CallableDemo1 {

    public static void main(String args[]) {
        SimpleCallable callable1 = new SimpleCallable(2000l);
        SimpleCallable callable2 = new SimpleCallable(4000l);

        FutureTask<String> futureTask1 = new FutureTask<>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<>(callable2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(futureTask1);
        executorService.execute(futureTask2);

        while (true) {
            try {
                if (futureTask1.isDone() && futureTask2.isDone()) {
                    System.out.println("Done");
                    executorService.shutdown();
                    return;
                }

                if (!futureTask2.isDone()) {
                    System.out.println("FutureTask1 output = " + futureTask1.get());
                }

                System.out.println("Waiting for futureTask2 to complete...");
                String s = futureTask2.get(200l, TimeUnit.MILLISECONDS);
                if (s != null) {
                    System.out.println("FutureTask2 output = " + futureTask2.get());
                }

            } catch (InterruptedException | ExecutionException exception) {
                exception.printStackTrace();
            } catch (TimeoutException timeout) {
            }
        }
    }

}
