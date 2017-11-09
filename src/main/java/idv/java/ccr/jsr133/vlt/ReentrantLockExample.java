package idv.java.ccr.jsr133.vlt;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carl Lu
 */
public class ReentrantLockExample {

    int a = 0;
    ReentrantLock reentrantLock = new ReentrantLock();

    public void write() {
        reentrantLock.lock();       // acquire lock
        try {
            a++;
        } finally {
            reentrantLock.unlock(); // release lock
        }
    }

    public void read() {
        reentrantLock.lock();       // acquire lock
        try {
            int i = a;
            // do something...
        } finally {
            reentrantLock.unlock(); // release lock
        }
    }
}
