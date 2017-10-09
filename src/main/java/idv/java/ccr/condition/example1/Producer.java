package idv.java.ccr.condition.example1;

import java.util.concurrent.locks.Lock;

/**
 * @author Carl Lu
 */
public class Producer implements Runnable {

    private final String threadColor;
    private final Lock lock;
    private final Shared shared;

    Producer(String threadColor, Shared shared) {
        this.threadColor = threadColor;
        this.shared = shared;
        this.lock = shared.getLock();
    }

    @Override
    public void run() {
        for (char ch = 'A'; ch < 'Z'; ch++) {
            lock.lock();
            shared.setSharedChar(ch);
            System.out.println(threadColor + ch + " produced by producer.");
            lock.unlock();
        }
    }

}
