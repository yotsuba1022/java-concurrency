package idv.java.ccr.threads.example1;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class MainThread {

    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_GREEN + "Echo from main thread");

        Thread subThread = new Thread(new SubThread());
        subThread.start();

        new Thread(() -> {
            System.out.println(ThreadColor.ANSI_CYAN + "Echo from anonymous thread");
        }).start();

        System.out.println(ThreadColor.ANSI_GREEN + "Echo again from main thread");

        // This line will cause: java.lang.IllegalThreadStateException
        // subThread.start();
    }

}
