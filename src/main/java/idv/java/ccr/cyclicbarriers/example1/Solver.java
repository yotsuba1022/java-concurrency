package idv.java.ccr.cyclicbarriers.example1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Carl Lu
 */
class Solver {

    private final int N;
    private final float[][] data;
    private final CyclicBarrier cyclicBarrier;
    private final Object lock = new Object();

    Solver(float[][] matrix) {
        data = matrix;
        N = matrix.length;
        cyclicBarrier = new CyclicBarrier(N, this::mergeRows);

        for (int i = 0; i < N; i++) {
            new Thread(new Worker(i)).start();
        }

        waitUntilDone();
    }

    private void mergeRows() {
        System.out.println("merging");
        synchronized (lock) {
            lock.notify();
        }
    }

    private void waitUntilDone() {
        synchronized (lock) {
            try {
                System.out.println("main thread waiting");
                lock.wait();
                System.out.println("main thread notified");
            } catch (InterruptedException e) {
                System.out.println("main thread interrupted");
            }
        }
    }

    class Worker implements Runnable {

        int row;
        boolean done = false;

        Worker(int row) {
            this.row = row;
        }

        public boolean isDone() {
            return done;
        }

        void processRow(int row) {
            System.out.println("Processing row: " + row);
            for (int i = 0; i < N; i++) {
                data[row][i] *= 10;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {

            }
            done = true;
        }

        @Override
        public void run() {
            while (!isDone()) {
                processRow(row);

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException ignored) {
                    return;
                }
            }
        }

    }

}
