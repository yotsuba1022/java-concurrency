package idv.java.ccr.reentrantlock.example1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carl Lu
 */
public class Worker implements Runnable {

    private final String threadColor;
    private final String name;
    private final ReentrantLock lock;

    Worker(String threadColor, String name, ReentrantLock lock) {
        this.threadColor = threadColor;
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            if (lock.isHeldByCurrentThread()) {
                System.out.printf(threadColor + "Thread %s entered critical section.%n", name);
                System.out.printf(threadColor + "Thread %s performing work.%n", name);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {
            }
            System.out.printf(threadColor + "Thread %s finished working.%n", name);
        } finally {
            lock.unlock();
        }
    }

}
