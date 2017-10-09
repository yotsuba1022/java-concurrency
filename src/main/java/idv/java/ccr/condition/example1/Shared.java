package idv.java.ccr.condition.example1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carl Lu
 */
public class Shared {

    private final Lock lock;
    private final Condition condition;
    private char character;
    private volatile boolean available;

    Shared() {
        this.available = false;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public Lock getLock() {
        return lock;
    }

    char getSharedChar() {
        lock.lock();
        try {
            while (!available) {
                try {
                    condition.await();
                } catch (InterruptedException ignored) {
                }
            }
            available = false;
            condition.signal();
            return character;
        } finally {
            lock.unlock();
        }
    }

    void setSharedChar(char character) {
        lock.lock();
        try {
            while (available) {
                try {
                    condition.await();
                } catch (InterruptedException ignored) {
                }
            }
            this.character = character;
            available = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
