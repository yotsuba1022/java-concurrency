package idv.java.ccr.threads.example2;

import java.math.BigDecimal;

/**
 * @author Carl Lu
 */
public class CachedVariableMain {

    private static BigDecimal result = BigDecimal.ONE;

    public static void main(String[] args) {
        Runnable r = () -> result = computePi();
        for (int i = 0; i < 10000; i++) {
            Thread t = new Thread(r);
            t.start();
            try {
                t.join();
            } catch (InterruptedException ignored) {
            }
            System.out.println(result);
        }
    }

    private static BigDecimal computePi() {
        return result.add(BigDecimal.ONE);
    }

}
