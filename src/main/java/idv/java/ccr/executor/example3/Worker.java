package idv.java.ccr.executor.example3;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Carl Lu
 */
public class Worker implements Runnable {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    private int no;
    private int time;

    public Worker(int no, int time) {
        this.no = no;
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(
                "No. " + no + " start id: " + Thread.currentThread().getId() + " live time: " + time + " current time: "
                        + simpleDateFormat.format(Calendar.getInstance().getTime()));
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException ignored) {
        }
        System.out.println("No. " + no + " end id: " + Thread.currentThread().getId() + " live time: " + time + " current time: "
                + simpleDateFormat.format(Calendar.getInstance().getTime()));
    }
}
