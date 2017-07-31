package idv.java.ccr.threads.example2;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class SleepThread implements Runnable {

    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_BRIGHT_CYAN + "Echo from " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ThreadColor.ANSI_BRIGHT_CYAN + "Another thread wake me up.");
        }

        System.out.println(ThreadColor.ANSI_BRIGHT_CYAN + "Three seconds have passed and I'm awake.");
    }

}
