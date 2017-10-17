package idv.java.ccr.completionservice.example2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.Callable;

/**
 * @author Carl Lu
 */
public class CalculateE implements Callable<BigDecimal> {

    final int lastIter;

    public CalculateE(int lastIter) {
        this.lastIter = lastIter;
    }

    @Override
    public BigDecimal call() throws Exception {
        MathContext mathContext = new MathContext(100, RoundingMode.HALF_UP);
        BigDecimal result = BigDecimal.ZERO;

        for (int i = 0; i < lastIter; i++) {
            BigDecimal factorial = factorial(new BigDecimal(i));
            BigDecimal tempResult = BigDecimal.ONE.divide(factorial, mathContext);
            result = result.add(tempResult);
        }
        return result;
    }

    private BigDecimal factorial(BigDecimal input) {
        if (input.equals(BigDecimal.ZERO)) {
            return BigDecimal.ONE;
        } else {
            return input.multiply(factorial(input.subtract(BigDecimal.ONE)));
        }
    }
}
