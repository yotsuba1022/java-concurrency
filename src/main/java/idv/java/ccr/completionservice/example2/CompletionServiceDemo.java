package idv.java.ccr.completionservice.example2;

import idv.java.ccr.util.ThreadColor;

import java.math.BigDecimal;
import java.util.concurrent.*;

/**
 * @author Carl Lu
 */
public class CompletionServiceDemo {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletionService<BigDecimal> completionService = new ExecutorCompletionService<>(executorService);
        completionService.submit(new CalculateE(17));
        completionService.submit(new CalculateE(170));

        Future<BigDecimal> future = completionService.take();
        System.out.println(ThreadColor.ANSI_CYAN + "Result 1: " + future.get());
        System.out.println();

        future = completionService.take();
        System.out.println(ThreadColor.ANSI_MAGENTA + "Result 2: " + future.get());
        executorService.shutdownNow();
    }

}
