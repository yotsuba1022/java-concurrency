package idv.java.ccr.jsr133.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Carl Lu
 */
public class Counter {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int nonAtomicInteger = 0;

    public void threadSafeCount() {
        for (; ; ) {
            int current = atomicInteger.get();
            boolean success = atomicInteger.compareAndSet(current, ++current);
            if (success) {
                break;
            }
        }
    }

    public void nonThreadSafeCount() {
        nonAtomicInteger++;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public int getNonAtomicInteger() {
        return nonAtomicInteger;
    }

}
