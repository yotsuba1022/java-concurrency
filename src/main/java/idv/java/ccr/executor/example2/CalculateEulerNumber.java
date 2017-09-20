package idv.java.ccr.executor.example2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.*;

/**
 * @author Carl Lu
 */
public class CalculateEulerNumber {

    private final static int LASTITER = 17;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<BigDecimal> callable;

        callable = new Callable<BigDecimal>() {
            @Override
            public BigDecimal call() throws Exception {
                MathContext mathContext = new MathContext(100, RoundingMode.HALF_UP);
                BigDecimal result = BigDecimal.ZERO;
                for (int i = 0; i <= LASTITER; i++) {
                    BigDecimal factorial = factorial(new BigDecimal(i));
                    BigDecimal tempResult = BigDecimal.ONE.divide(factorial, mathContext);

                    result = result.add(tempResult);
                }
                return result;
            }

            BigDecimal factorial(BigDecimal n) {
                if (n.equals(BigDecimal.ZERO)) {
                    return BigDecimal.ONE;
                } else {
                    return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
                }
            }
        };

        Future<BigDecimal> taskFuture = executorService.submit(callable);

        try {
            while (!taskFuture.isDone()) {
                System.out.println("Executing computation task...");
            }
            System.out.println(taskFuture.get());
        } catch (InterruptedException | ExecutionException ignored) {

        }

        executorService.shutdownNow();
    }

}
