package idv.java.ccr.threads.example2;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(
                ThreadColor.ANSI_GREEN + "Echo from MyRunnable's run impl, thread name: " + Thread.currentThread().getName());
    }

}
