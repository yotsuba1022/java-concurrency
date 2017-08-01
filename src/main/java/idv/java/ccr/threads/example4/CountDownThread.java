package idv.java.ccr.threads.example4;

/**
 * @author Carl Lu
 */
public class CountDownThread implements Runnable {

    private CountDown countDown;

    public CountDownThread(CountDown countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        countDown.doCountDown();
    }

}
