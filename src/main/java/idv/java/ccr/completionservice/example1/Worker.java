package idv.java.ccr.completionservice.example1;

import java.util.concurrent.Callable;

/**
 * @author Carl Lu
 */
public class Worker implements Callable<String> {

    private final String threadColor;

    public Worker(String threadColor) {
        this.threadColor = threadColor;
    }

    @Override
    public String call() throws Exception {
        String threadName = Thread.currentThread().getName();
        try {
            Thread.sleep((long) ( Math.random() * 300 ));
            System.out.println(threadColor + threadName + "executing...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return threadColor + threadName + " done.";
    }
}
