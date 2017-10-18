package idv.java.ccr.executor.example3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Carl Lu
 */
public class Main {

    public static void main(String[] args) {
        final int MAX_THREADS = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);

        for (int i = 0; i < 10; i++) {
            int lifeTime = (int) ( Math.random() * 9 + 1 );
            executorService.submit(new Worker(i, lifeTime));
        }

        System.out.println("Executor shutdown.");
        executorService.shutdown();
        executorService.shutdownNow();
    }

}
