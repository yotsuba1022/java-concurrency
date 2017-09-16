package idv.java.ccr.threads.example23;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Carl Lu
 */
public class TimerDemo {

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Alarm going off.");
                System.exit(0);
            }
        };

        Timer timer = new Timer();
        // Execute one-shot timer task after 2 secs.
        timer.schedule(timerTask, 2000);
    }

}
