package idv.java.ccr.threads.example1;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class SubThread implements Runnable {

    public void run() {
        System.out.println(ThreadColor.ANSI_MAGENTA + "Echo from sub thread.");
    }

}
