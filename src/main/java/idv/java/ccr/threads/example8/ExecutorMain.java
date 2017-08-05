package idv.java.ccr.threads.example8;

import idv.java.ccr.util.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carl Lu
 */
public class ExecutorMain {

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        SimpleProducer producer = new SimpleProducer(buffer, ThreadColor.ANSI_CYAN, bufferLock);
        SimpleConsumer consumer1 = new SimpleConsumer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        SimpleConsumer consumer2 = new SimpleConsumer(buffer, ThreadColor.ANSI_MAGENTA, bufferLock);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(() -> {
            System.out.println(ThreadColor.ANSI_BLUE + "I'm being printed for the callable class");
            return "This is the callable result";
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

}
