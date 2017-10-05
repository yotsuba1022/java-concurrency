package idv.java.ccr.phaser.example1;

/**
 * @author Carl Lu
 */
public class PhaseTask implements Runnable {

    private String threadColor;

    PhaseTask(String threadColor) {
        this.threadColor = threadColor;
    }

    @Override
    public void run() {
        System.out.printf(threadColor + "%s running at %d%n", Thread.currentThread().getName(), System.currentTimeMillis());
    }

}
