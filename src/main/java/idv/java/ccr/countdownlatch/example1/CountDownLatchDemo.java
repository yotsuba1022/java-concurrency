package idv.java.ccr.countdownlatch.example1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Carl Lu
 */
public class CountDownLatchDemo {

    private final static int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch doneSignal = new CountDownLatch(NUMBER_OF_THREADS);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    report("Entered run method of runnable...");
                    startSignal.await();
                    report("Doing work...");
                    Thread.sleep((int) ( Math.random() * 1000 ));
                    doneSignal.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            void report(String input) {
                System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread() + ": " + input);
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executorService.execute(runnable);
        }

        try {
            System.out.println("Main thread doing something...");
            Thread.sleep(1000);
            startSignal.countDown(); // Let all threads processed.
            System.out.println("main thread doing something else...");
            doneSignal.await(); // Wait for all threads to finished.
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
