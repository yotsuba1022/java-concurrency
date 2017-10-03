package idv.java.ccr.semaphore.example1;

import java.util.concurrent.Semaphore;

/**
 * @author Carl Lu
 */
public class SemaphoreDemo1 {

    private static final int MAX_CONCURRENT_THREADS = 2;
    private final Semaphore semaphoreLock = new Semaphore(MAX_CONCURRENT_THREADS, true);

    public static void main(String args[]) {
        SemaphoreDemo1 demo = new SemaphoreDemo1();
        demo.personAccessTest();
    }

    public void personAccessTest() {
        for (int i = 0; i < 10; i++) {
            Person person = new Person(semaphoreLock, i);
            new Thread(person).start();
        }
    }

}
