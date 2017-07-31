package idv.java.ccr.threads.example2;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class Main {

    public static void main(String[] args) {
        Thread threadInvokeByMain = new Thread(new MyRunnable());
        threadInvokeByMain.setName("ThreadMain");
        threadInvokeByMain.run();

        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.setName("myRunThread1");
        myRunnableThread.start();

        Thread myRunnableThread2 = new Thread(new MyRunnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("MyRunnable Thread2");
                System.out.println(ThreadColor.ANSI_MAGENTA + "Echo MyRunnable from thread: " + Thread.currentThread().getName());
            }
        });
        myRunnableThread2.start();

        Thread sleepThread = new Thread(new SleepThread());
        sleepThread.start();
    }

}
