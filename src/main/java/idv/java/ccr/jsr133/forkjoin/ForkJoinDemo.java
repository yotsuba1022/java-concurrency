package idv.java.ccr.jsr133.forkjoin;

import idv.java.ccr.util.ThreadColor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * @author Carl Lu
 */
public class ForkJoinDemo {

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1, 100);
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(ThreadColor.ANSI_BRIGHT_GREEN + "Sum result of 1 to 100: " + result.get());
        } catch (InterruptedException | ExecutionException ignore) {
        }

    }

}
