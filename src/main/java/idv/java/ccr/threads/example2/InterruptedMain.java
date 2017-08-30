package idv.java.ccr.threads.example2;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class InterruptedMain {

    public static void main(String[] args) {
        String mainThreadConsoleColor = ThreadColor.ANSI_YELLOW;
        String thread1ConsoleColor = ThreadColor.ANSI_CYAN;
        String thread2ConsoleColor = ThreadColor.ANSI_MAGENTA;

        Thread thdA = new Thread(() -> {
            String name = Thread.currentThread().getName();
            int count = 0;
            while (!Thread.interrupted())
                System.out.println(thread1ConsoleColor + name + ": " + count++ + ", is interrupted: " + Thread.currentThread()
                        .isInterrupted());
        }, "Thread1");

        Thread thdB = new Thread(() -> {
            String name = Thread.currentThread().getName();
            int count = 0;
            while (!Thread.interrupted())
                System.out.println(thread2ConsoleColor + name + ": " + count++ + ", is interrupted: " + Thread.currentThread()
                        .isInterrupted());
        }, "Thread2");

        thdA.start();
        thdB.start();

        try {
            System.out.println(mainThreadConsoleColor + "Wait 2 secs...");
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }

        thdA.interrupt();
        thdB.interrupt();

        System.out.println(
                thread1ConsoleColor + "Thread1 is interrupted: " + thdA.isInterrupted() + ", state: " + thdA.getState());
        System.out.println(
                thread2ConsoleColor + "Thread2 is interrupted: " + thdB.isInterrupted() + ", state: " + thdB.getState());

        try {
            System.out.println(mainThreadConsoleColor + "Wait 2 secs...");
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }

        System.out.println(
                thread1ConsoleColor + "Thread1 is interrupted: " + thdA.isInterrupted() + ", state: " + thdA.getState());
        System.out.println(
                thread2ConsoleColor + "Thread2 is interrupted: " + thdB.isInterrupted() + ", state: " + thdB.getState());
    }

}
