package idv.java.ccr.threads.countdown.demo;

/**
 * @author Carl Lu
 */
class LocalCountDownThread extends Thread {

    private CountDown threadCountDown;

    public LocalCountDownThread(CountDown countDown) {
        this.threadCountDown = countDown;
    }

    public void run() {
        threadCountDown.doCountDown();
    }

}
