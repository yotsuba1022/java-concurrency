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

    private final Matrix inputMatrixA, inputMatrixB, resultMatrix;
    private final int row;

    private MatrixMultiWithForkJoinPool(Matrix inputMatrixA, Matrix inputMatrixB, Matrix resultMatrix) {
        this(inputMatrixA, inputMatrixB, resultMatrix, -1);
    }

    private MatrixMultiWithForkJoinPool(Matrix inputMatrixA, Matrix inputMatrixB, Matrix resultMatrix, int row) {
        if (inputMatrixA.getCols() != inputMatrixB.getRows()) {
            throw new IllegalArgumentException("rows/columns mismatch.");
        }
        this.inputMatrixA = inputMatrixA;
        this.inputMatrixB = inputMatrixB;
        this.resultMatrix = resultMatrix;
        this.row = row;
    }

    private static void multiplyRowByColumn(Matrix inputMatrixA, Matrix inputMatrixB, Matrix resultMatrix, int row) {
        for (int j = 0; j < inputMatrixB.getCols(); j++) {
            for (int k = 0; k < inputMatrixA.getCols(); k++) {
                resultMatrix.setValue(row, j,
                        resultMatrix.getValue(row, j) + inputMatrixA.getValue(row, k) * inputMatrixB.getValue(k, j));
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
        Matrix inputMatrixA = new Matrix(2, 3);
        inputMatrixA.setValue(0, 0, 1);
        inputMatrixA.setValue(0, 1, 2);
        inputMatrixA.setValue(0, 2, 3);
        inputMatrixA.setValue(1, 0, 4);
        inputMatrixA.setValue(1, 1, 5);
        inputMatrixA.setValue(1, 2, 6);
        dump(inputMatrixA);

        Matrix inputMatrixB = new Matrix(3, 2);
        inputMatrixB.setValue(0, 0, 7);
        inputMatrixB.setValue(1, 0, 8);
        inputMatrixB.setValue(2, 0, 9);
        inputMatrixB.setValue(0, 1, 1);
        inputMatrixB.setValue(1, 1, 2);
        inputMatrixB.setValue(2, 1, 3);
        dump(inputMatrixB);

        Matrix resultMatrix = new Matrix(2, 2);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new MatrixMultiWithForkJoinPool(inputMatrixA, inputMatrixB, resultMatrix));
        dump(resultMatrix);
    }

    @Override
    protected void compute() {
        if (row == -1) {
            List<MatrixMultiWithForkJoinPool> tasks = new ArrayList<>();
            for (int row = 0; row < inputMatrixA.getRows(); row++) {
                tasks.add(new MatrixMultiWithForkJoinPool(inputMatrixA, inputMatrixB, resultMatrix, row));
            }
            invokeAll(tasks);
        } else {
            multiplyRowByColumn(inputMatrixA, inputMatrixB, resultMatrix, row);
        }
    }

}
