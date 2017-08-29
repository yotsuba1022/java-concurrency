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

        System.out.println(mainThreadConsoleColor + "Available processors: " + Runtime.getRuntime().availableProcessors());

        Thread thread1 = new Thread(() -> {
            System.out.println(thread1ConsoleColor + "In thread1");
            showThreadStatus(Thread.currentThread(), thread1ConsoleColor);
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            System.out.println(thread2ConsoleColor + "In thread2");
            showThreadStatus(Thread.currentThread(), thread2ConsoleColor);
        }, "Thread2");

        System.out.println(mainThreadConsoleColor + "Before execution:");
        showThreadStatus(thread1, thread1ConsoleColor);
        showThreadStatus(thread2, thread2ConsoleColor);

        System.out.println(mainThreadConsoleColor + "Start execution:");
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

        System.out.println(mainThreadConsoleColor + "After execution:");
        showThreadStatus(thread1, thread1ConsoleColor);
        showThreadStatus(thread2, thread2ConsoleColor);
    }

    private static void showThreadStatus(Thread thread, String consoleColor) {
        System.out.println(
                consoleColor + "Thread name: " + thread.getName() + ", id: " + thread.getId() + ", is alive: " + thread.isAlive()
                        + ", is daemon: " + thread.isDaemon() + ", execution state: " + thread.getState());
    }

}
