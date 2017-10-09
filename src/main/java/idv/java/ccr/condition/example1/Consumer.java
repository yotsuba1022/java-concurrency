package idv.java.ccr.condition.example1;

import java.util.concurrent.locks.Lock;

/**
 * @author Carl Lu
 */
public class Consumer implements Runnable {

    private final String threadColor;
    private final Shared shared;
    private final Lock lock;

    Consumer(String threadColor, Shared shared) {
        this.threadColor = threadColor;
        this.shared = shared;
        this.lock = shared.getLock();
    }

    @Override
    public void run() {
        char ch;

        do {
            lock.lock();
            ch = shared.getSharedChar();
            System.out.println(threadColor + ch + " consumed by consumer.");
            lock.unlock();
        } while (ch != 'Z');
    }

}
