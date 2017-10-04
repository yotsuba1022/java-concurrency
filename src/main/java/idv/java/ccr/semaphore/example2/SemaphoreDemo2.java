package idv.java.ccr.semaphore.example2;

import idv.java.ccr.util.ThreadColor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Carl Lu
 */
public class SemaphoreDemo2 {

    public static void main(String[] args) {
        final Pool pool = new Pool();
        ExecutorService[] executorServices = new ExecutorService[Pool.MAX_AVAILABLE + 1];
        for (int i = 0; i < executorServices.length; i++) {
            executorServices[i] = Executors.newSingleThreadExecutor();
            String threadColor = ThreadColor.ANSI_BLUE;
            if (i % 2 == 0) {
                threadColor = ThreadColor.ANSI_CYAN;
            }
            if (i % 3 == 0) {
                threadColor = ThreadColor.ANSI_YELLOW;
            }
            if (i % 5 == 0) {
                threadColor = ThreadColor.ANSI_GREEN;
            }
            if (i % 7 == 0) {
                threadColor = ThreadColor.ANSI_MAGENTA;
            }
            executorServices[i].execute(new Consumer(threadColor, pool));
        }
    }

}
