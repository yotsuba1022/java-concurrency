package idv.java.ccr.threads.example23;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Carl Lu
 */
public class TimerDemo2 {

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis());
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 0, 1000);
    }

}
