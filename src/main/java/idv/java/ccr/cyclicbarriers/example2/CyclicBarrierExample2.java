package idv.java.ccr.cyclicbarriers.example2;

import idv.java.ccr.util.ThreadColor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Carl Lu
 */
public class CyclicBarrierExample2 {

    private final static int NUMBER_OF_THREADS = 4;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER_OF_THREADS);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            if (i < NUMBER_OF_THREADS - 1) {
                new Thread(new Writer(cyclicBarrier)).start();
            } else {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {
                }
                new Thread(new Writer(cyclicBarrier)).start();
            }
        }
    }

    private static class Writer implements Runnable {
        private CyclicBarrier cyclicBarrier;

        Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(ThreadColor.ANSI_CYAN + "Thread " + Thread.currentThread().getName() + " is now writing data...");
            try {
                Thread.sleep(5000);
                System.out.println(ThreadColor.ANSI_CYAN + "Thread " + Thread.currentThread().getName()
                        + " finished writing data, wait for other threads");
                cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println(
                    ThreadColor.ANSI_CYAN + "Thread " + Thread.currentThread().getName() + "All threads tasks finished.");
        }
    }

}
