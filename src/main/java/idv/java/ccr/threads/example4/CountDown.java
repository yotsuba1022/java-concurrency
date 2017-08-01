package idv.java.ccr.threads.example4;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
class CountDown {
    private int i;

    void doCountDown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_MAGENTA;
                break;
            default:
                color = ThreadColor.ANSI_YELLOW;
                break;
        }

        /*
        * You should choose where to synchronized carefully cuz it will affect the performance,
        * the smaller your critical region is, the faster your code can run.
        * */
        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }
}
