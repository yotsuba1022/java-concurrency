package idv.java.ccr.callable;

import java.util.concurrent.Callable;

/**
 * @author Carl Lu
 */
public class SimpleCallable implements Callable {

    private long waitTime;

    public SimpleCallable(long waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public Object call() throws Exception {
        Thread.sleep(waitTime);
        return Thread.currentThread().getName();
    }
}
