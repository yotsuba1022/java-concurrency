package idv.java.ccr.forkjoin.example1;

/**
 * @author Carl Lu
 */
public class MatrixMult {

    public static void main(String[] args) {
        // | 1, 2, 3|
        Matrix a = new Matrix(1, 3);
        a.setValue(0, 0, 1);
        a.setValue(0, 1, 2);
        a.setValue(0, 2, 3);
        dump(a);

        // | 4, 7 |
        // | 5, 8 |
        // | 6, 9 |
        Matrix b = new Matrix(3, 2);
        b.setValue(0, 0, 4);
        b.setValue(1, 0, 5);
        b.setValue(2, 0, 6);
        b.setValue(0, 1, 7);
        b.setValue(1, 1, 8);
        b.setValue(2, 1, 9);
        dump(b);
        long start = System.currentTimeMillis();
        dump(multiply(a, b));
        long end = System.currentTimeMillis();
        System.out.println("Matrix multiplication operation cost: " + ( end - start ) + " msecs.");
    }

    public static void dump(Matrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                System.out.printf("%d ", matrix.getValue(i, j));
            }
            System.out.println();
        }
        System.out.println();
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException("row/columns mismatch.");
        } else {
            Matrix result = new Matrix(a.getRows(), b.getCols());
            for (int i = 0; i < a.getRows(); i++) {
                for (int j = 0; j < b.getCols(); j++) {
                    for (int k = 0; k < a.getCols(); k++) {
                        result.setValue(i, j, result.getValue(i, j) + a.getValue(i, k) * b.getValue(k, j));
                    }
                }
            }
            return result;
        }
    }

}
