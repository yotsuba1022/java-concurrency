package idv.java.ccr.threads;

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
