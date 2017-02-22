package idv.java.ccr.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carl Lu
 */
public class Guy {

    private final String name;

    /*
     * ReentrantLock: Creates an instance of ReentrantLock.
     * This is equivalent to using ReentrantLock(false)
     */
    private final Lock lock = new ReentrantLock();

    public Guy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isTalking(Guy guy) {
        Boolean selfLock = false;
        Boolean otherLock = false;

        try {
            /*
             * tryLock: Acquires the lock only if it is free at the time of invocation.
             */
            selfLock = lock.tryLock();
            otherLock = guy.lock.tryLock();
        } finally {
            if (!(selfLock && otherLock)) {
                if (selfLock) {
                    // unlock: Releases the lock.
                    lock.unlock();
                }
                if (otherLock) {
                    guy.lock.unlock();
                }
            }
        }

        return selfLock && otherLock;
    }

    public void talking(Guy guy) {
        if (isTalking(guy)) {
            try {
                System.out.format("I'm %s: talking to %s %n", this.getName(), guy.getName());
            } finally {
                lock.unlock();
                guy.lock.unlock();
            }
        } else {
            System.out.format("Lock occurred -> I'm %s: talking to %s, but it seems we are already talking. Conflicting %n",
                    this.getName(), guy.getName());
        }
    }
}
