package idv.java.ccr.forkjoin.example2;

import idv.java.ccr.forkjoin.example1.Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author Carl Lu
 */
public class MatrixMultiWithForkJoinPool extends RecursiveAction {

    private final Matrix a, b, c;
    private final int row;

    private MatrixMultiWithForkJoinPool(Matrix a, Matrix b, Matrix c) {
        this(a, b, c, -1);
    }

    private MatrixMultiWithForkJoinPool(Matrix a, Matrix b, Matrix c, int row) {
        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException("rows/columns mismatch.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.row = row;
    }

    private static void multiplyRowByColumn(Matrix a, Matrix b, Matrix c, int row) {
        for (int j = 0; j < b.getCols(); j++) {
            for (int k = 0; k < a.getCols(); k++) {
                c.setValue(row, j, c.getValue(row, j) + a.getValue(row, k) * b.getValue(k, j));
            }
        }
    }

    private static void dump(Matrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                System.out.print(matrix.getValue(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Matrix a = new Matrix(2, 3);
        a.setValue(0, 0, 1);
        a.setValue(0, 1, 2);
        a.setValue(0, 2, 3);
        a.setValue(1, 0, 4);
        a.setValue(1, 1, 5);
        a.setValue(1, 2, 6);
        dump(a);

        Matrix b = new Matrix(3, 2);
        b.setValue(0, 0, 7);
        b.setValue(1, 0, 8);
        b.setValue(2, 0, 9);
        b.setValue(0, 1, 1);
        b.setValue(1, 1, 2);
        b.setValue(2, 1, 3);
        dump(b);

        Matrix c = new Matrix(2, 2);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new MatrixMultiWithForkJoinPool(a, b, c));
        dump(c);
    }

    @Override
    protected void compute() {
        if (row == -1) {
            List<MatrixMultiWithForkJoinPool> tasks = new ArrayList<>();
            for (int row = 0; row < a.getRows(); row++) {
                tasks.add(new MatrixMultiWithForkJoinPool(a, b, c, row));
            }
            invokeAll(tasks);
        } else {
            multiplyRowByColumn(a, b, c, row);
        }
    }

}
