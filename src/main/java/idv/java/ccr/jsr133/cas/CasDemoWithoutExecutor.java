package idv.java.ccr.jsr133.cas;

import idv.java.ccr.util.ThreadColor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carl Lu
 */
public class CasDemoWithoutExecutor {

    private final static int MAX_COUNT = 10000;
    private final static int MAX_THREAD_NUM = 300;
    private final static int DEFAULT_THREAD_POOL_SIZE = 500;
    private final static int EXPECTED_TOTAL_COUNT = MAX_COUNT * MAX_THREAD_NUM;

    public static void main(String[] args) {

        final Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>(DEFAULT_THREAD_POOL_SIZE);
        long startTime = System.currentTimeMillis();

        for (int createRound = 0; createRound < MAX_THREAD_NUM; createRound++) {
            Thread thread = new Thread(() -> {
                for (int count = 0; count < MAX_COUNT; count++) {
                    counter.nonThreadSafeCount();
                    counter.threadSafeCount();
                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
            }
        }

        long endTime = System.currentTimeMillis();
        int nonAtomicResult = counter.getNonAtomicInteger();
        int atomicResult = counter.getAtomicInteger().get();
        double loseRate = (double) ( EXPECTED_TOTAL_COUNT - nonAtomicResult ) / EXPECTED_TOTAL_COUNT;

        System.out.println(ThreadColor.ANSI_MAGENTA + "Non thread-safe integer result: " + nonAtomicResult);
        System.out.println(ThreadColor.ANSI_CYAN + "Thread-safe atomic integer result: " + atomicResult);
        System.out.println("Counting lose rate: " + loseRate);
        System.out.println("Total cost time: " + ( endTime - startTime ) + " msecs.");
    }

}
