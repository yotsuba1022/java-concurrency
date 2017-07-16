package idv.java.ccr.threads;

/**
 * @author Carl Lu
 */
class InstanceCountDownThread extends Thread {

    private CountDown threadCountDown;

    public InstanceCountDownThread(CountDown countDown) {
        this.threadCountDown = countDown;
    }

    public void run() {
        threadCountDown.doCountDownWithInstanceLevelLoopCounter();
    }

}
