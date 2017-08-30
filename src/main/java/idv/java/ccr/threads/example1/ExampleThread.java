package idv.java.ccr.threads.example1;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class ExampleThread {

    public static void main(String[] args) {
        String mainThreadConsoleColor = ThreadColor.ANSI_YELLOW;
        String thread1ConsoleColor = ThreadColor.ANSI_CYAN;
        String thread2ConsoleColor = ThreadColor.ANSI_MAGENTA;
        String thread3ConsoleColor = ThreadColor.ANSI_GREEN;

        System.out.println(mainThreadConsoleColor + "Available processors: " + Runtime.getRuntime().availableProcessors());

        Thread thread1 = new Thread(() -> {
            System.out.println(thread1ConsoleColor + "In thread1");
            showThreadStatus(Thread.currentThread(), thread1ConsoleColor);
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            System.out.println(thread2ConsoleColor + "In thread2");
            showThreadStatus(Thread.currentThread(), thread2ConsoleColor);
        }, "Thread2");

        Thread thread3 = new Thread(() -> {
            System.out.println(thread3ConsoleColor + "In thread3");
            showThreadStatus(Thread.currentThread(), thread3ConsoleColor);
        }, "Thread3");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.setDaemon(true);
        thread2.setPriority(Thread.MAX_PRIORITY);

        System.out.println(mainThreadConsoleColor + "Before execution:");
        showThreadStatus(thread1, thread1ConsoleColor);
        showThreadStatus(thread2, thread2ConsoleColor);
        showThreadStatus(thread3, thread3ConsoleColor);

        System.out.println(mainThreadConsoleColor + "Start execution:");
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.interrupt();

        try {
            thread1.join();
        } catch (InterruptedException ignored) {
        }

        try {
            thread2.join();
        } catch (InterruptedException ignored) {
        }

        try {
            thread3.join();
        } catch (InterruptedException ignored) {
        }

        System.out.println(mainThreadConsoleColor + "After execution:");
        showThreadStatus(thread1, thread1ConsoleColor);
        showThreadStatus(thread2, thread2ConsoleColor);
        showThreadStatus(thread3, thread3ConsoleColor);
    }

    private static void showThreadStatus(Thread thread, String consoleColor) {
        System.out.println(
                consoleColor + "Thread name: " + thread.getName() + ", id: " + thread.getId() + ", is alive: " + thread.isAlive()
                        + ", is daemon: " + thread.isDaemon() + ", execution state: " + thread.getState() + ", priority: "
                        + thread.getPriority());
    }

}
