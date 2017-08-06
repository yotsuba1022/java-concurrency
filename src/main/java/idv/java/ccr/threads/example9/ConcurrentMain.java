package idv.java.ccr.threads.example9;

import idv.java.ccr.util.ThreadColor;

import java.util.concurrent.*;

/**
 * @author Carl Lu
 */
public class ConcurrentMain {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        SimpleProducer producer = new SimpleProducer(buffer, ThreadColor.ANSI_CYAN);
        SimpleConsumer consumer1 = new SimpleConsumer(buffer, ThreadColor.ANSI_MAGENTA);
        SimpleConsumer consumer2 = new SimpleConsumer(buffer, ThreadColor.ANSI_YELLOW);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(() -> {
            System.out.println(ThreadColor.ANSI_GREEN + "I'm being printed for the Callable class");
            return "This is the callable result";
        });

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

}
