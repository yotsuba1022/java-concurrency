package idv.java.ccr.jsr133.cas;

import idv.java.ccr.util.ThreadColor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Carl Lu
 */
public class CasDemo {

    private final static int MAX_COUNT = 10000;
    private final static int MAX_THREAD_NUM = 300;
    private final static int EXPECTED_TOTAL_COUNT = MAX_COUNT * MAX_THREAD_NUM;

    public static void main(String[] args) {

        final Counter counter = new Counter();
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(MAX_THREAD_NUM);
        long startTime = System.currentTimeMillis();

        for (int createRound = 0; createRound < MAX_THREAD_NUM; createRound++) {
            Thread thread = new Thread(() -> {
                for (int count = 0; count < MAX_COUNT; count++) {
                    counter.nonThreadSafeCount();
                    counter.threadSafeCount();
                }
            });
            executorService.execute(thread);
        }

        /*
        * If we didn't invoke shutdown() here,
        * it might cause the output result incorrect since that there might still some tasks are not finished yet.
        * */
        executorService.shutdown();

        long endTime = System.currentTimeMillis();
        long completedTaskCount = executorService.getCompletedTaskCount();
        int nonAtomicResult = counter.getNonAtomicInteger();
        int atomicResult = counter.getAtomicInteger().get();
        double loseRate = (double) ( EXPECTED_TOTAL_COUNT - nonAtomicResult ) / EXPECTED_TOTAL_COUNT;

        System.out.println(ThreadColor.ANSI_MAGENTA + "Non thread-safe integer result: " + nonAtomicResult);
        System.out.println(ThreadColor.ANSI_CYAN + "Thread-safe atomic integer result: " + atomicResult);
        System.out.println("Counting lose rate: " + loseRate);
        System.out.println("Total cost time: " + ( endTime - startTime ) + " msecs.");
        System.out.println(ThreadColor.ANSI_BRIGHT_GREEN + "Complete task count: " + completedTaskCount);
    }

}
