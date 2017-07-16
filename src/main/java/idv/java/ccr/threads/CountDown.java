package idv.java.ccr.threads;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
class CountDown {

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
        int i;
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

        for (i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
        }
    }

}
