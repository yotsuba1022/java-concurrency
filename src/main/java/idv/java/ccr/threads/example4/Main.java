package idv.java.ccr.threads.example4;

/**
 * @author Carl Lu
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountDown countDown = new CountDown();

        CountDownThread cdt1 = new CountDownThread(countDown);
        CountDownThread cdt2 = new CountDownThread(countDown);

        Thread t1 = new Thread(cdt1);
        Thread t2 = new Thread(cdt2);
        t1.setName("Thread 1");
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }

}
