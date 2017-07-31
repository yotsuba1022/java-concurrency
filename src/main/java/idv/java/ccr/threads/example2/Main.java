package idv.java.ccr.threads.example2;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class Main {

    public static void main(String[] args) {
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.setName("myRunThread1");
        myRunnableThread.start();

        Thread myRunnableThread2 = new Thread(new MyRunnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("MyRunnable Thread2");
                System.out.println(ThreadColor.ANSI_MAGENTA + "Echo MyRunnable from thread: " + Thread.currentThread().getName());

                try {
                    myRunnableThread.join(2000);
                    System.out.println(
                            ThreadColor.ANSI_BRIGHT_MAGENTA + "myRunnableThread terminated, or time out, so I'm running again.");
                } catch (InterruptedException e) {
                    System.out.println("I couldn't wait after all.");
                }
            }
        });
        myRunnableThread2.start();

        Thread sleepThread = new Thread(new SleepThread());
        sleepThread.start();
        sleepThread.interrupt();
    }

}
