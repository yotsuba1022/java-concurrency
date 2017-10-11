package idv.java.ccr.ccrcollections.queue.example1;

import java.util.concurrent.BlockingQueue;

/**
 * @author Carl Lu
 */
public class Producer implements Runnable {

    private String threadColor;
    private BlockingQueue<Character> blockingQueue;

    public Producer(String threadColor, BlockingQueue<Character> blockingQueue) {
        this.threadColor = threadColor;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            try {
                blockingQueue.put(ch);
                System.out.printf(threadColor + "%c produced by producer.%n", ch);
            } catch (InterruptedException ignored) {
            }
        }
    }

}
