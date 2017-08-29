package idv.java.ccr.threads.example1;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class ExampleThread {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println(ThreadColor.ANSI_CYAN + "In thread1");
            showThreadStatus(Thread.currentThread());
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            System.out.println(ThreadColor.ANSI_MAGENTA + "In thread2");
            showThreadStatus(Thread.currentThread());
        }, "Thread2");

        System.out.println(ThreadColor.ANSI_YELLOW + "Before execution:");
        showThreadStatus(thread1);
        showThreadStatus(thread2);

        System.out.println(ThreadColor.ANSI_GREEN + "Start execution:");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException ignored) {
        }

        try {
            thread2.join();
        } catch (InterruptedException ignored) {
        }

        System.out.println(ThreadColor.ANSI_BLUE + "After execution:");
        showThreadStatus(thread1);
        showThreadStatus(thread2);
    }

    private static void showThreadStatus(Thread thread) {
        System.out.println("Thread name: " + thread.getName() + ", id: " + thread.getId() + ", is alive: " + thread.isAlive()
                + ", is daemon: " + thread.isDaemon() + ", execution state: " + thread.getState());
    }

}
