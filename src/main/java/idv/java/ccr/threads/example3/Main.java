package idv.java.ccr.threads.example3;

/**
 * @author Carl Lu
 */
public class Main {

    /*
    * We can't guarantee the execution order of multi-thread.
    * */
    public static void main(String[] args) throws InterruptedException {
        CountDown countDown = new CountDown();

        /*
        * Count with local loop counter
        * */
        LocalCountDownThread thread1 = new LocalCountDownThread(countDown);
        thread1.setName("Thread 1");

        LocalCountDownThread thread2 = new LocalCountDownThread(countDown);
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();

        /*
        * Count with local loop counter
        * */
        InstanceCountDownThread thread3 = new InstanceCountDownThread(countDown);
        thread3.setName("Thread 3");

        InstanceCountDownThread thread4 = new InstanceCountDownThread(countDown);
        thread4.setName("Thread 4");

        thread3.start();
        thread4.start();
    }

}
