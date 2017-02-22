package idv.java.ccr.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author Carl Lu
 */
public class Person implements Runnable {

    private int id;
    private Semaphore semaphore;

    public Person(Semaphore semaphore, int id) {
        this.id = id;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException interruptedException) {
            System.out.println("InterruptedException");
            return;
        }

        System.out.println("Thread " + id + " is now accessing shared resources. (Acquire)");

        try {
            Thread.sleep(2000);
        } catch (Exception exception) {

        } finally {
            semaphore.release();
        }

        System.out.println("Thread " + id + " already released shared resources. (Release)");
        System.out.println();
    }
}
