package idv.java.ccr.ccrcollections.queue.example1;

import idv.java.ccr.util.ThreadColor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Carl Lu
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {
        final BlockingQueue<Character> blockingQueue = new ArrayBlockingQueue<>(26);
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Thread(new Producer(ThreadColor.ANSI_CYAN, blockingQueue)));
        executorService.execute(new Thread(new Consumer(ThreadColor.ANSI_MAGENTA, blockingQueue, executorService)));
    }

}
