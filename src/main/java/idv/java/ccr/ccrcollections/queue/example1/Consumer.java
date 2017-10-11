package idv.java.ccr.ccrcollections.queue.example1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

/**
 * @author Carl Lu
 */
public class Consumer implements Runnable {

    private String threadColor;
    private BlockingQueue<Character> blockingQueue;
    private ExecutorService executorService;

    public Consumer(String threadColor, BlockingQueue<Character> blockingQueue, ExecutorService executorService) {
        this.threadColor = threadColor;
        this.blockingQueue = blockingQueue;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        char ch = '\0';
        do {
            try {
                ch = blockingQueue.take();
                System.out.printf(threadColor + "%c consumed by consumer.%n", ch);
            } catch (InterruptedException ignored) {
            }
        } while (ch != 'Z');
        executorService.shutdownNow();
    }
}
