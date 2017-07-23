package idv.java.ccr.threads.countdown.demo;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
class CountDown {

    private int instanceLoopCounter;

    public void doCountDown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        for (int i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
        }
    }

    public void doCountDownWithInstanceLevelLoopCounter() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 3":
                color = ThreadColor.ANSI_YELLOW;
                break;
            case "Thread 4":
                color = ThreadColor.ANSI_BLUE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        for (instanceLoopCounter = 10; instanceLoopCounter > 0; instanceLoopCounter--) {
            System.out.println(color + Thread.currentThread().getName() + ": i = " + instanceLoopCounter);
        }
    }

}
