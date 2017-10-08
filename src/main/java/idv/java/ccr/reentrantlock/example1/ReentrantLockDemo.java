package idv.java.ccr.reentrantlock.example1;

import idv.java.ccr.util.ThreadColor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carl Lu
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        final ReentrantLock lock = new ReentrantLock();

        executorService.execute(new Worker(ThreadColor.ANSI_CYAN, "Thread1", lock));
        executorService.execute(new Worker(ThreadColor.ANSI_GREEN, "Thread2", lock));
        executorService.execute(new Worker(ThreadColor.ANSI_BLUE, "Thread3", lock));
        executorService.execute(new Worker(ThreadColor.ANSI_YELLOW, "Thread4", lock));
        executorService.execute(new Worker(ThreadColor.ANSI_MAGENTA, "Thread5", lock));
        executorService.execute(new Worker(ThreadColor.ANSI_CYAN, "Thread6", lock));

        try {
            executorService.awaitTermination(12, TimeUnit.SECONDS);
        } catch (InterruptedException ignored) {
        }

        executorService.shutdownNow();
    }

}
