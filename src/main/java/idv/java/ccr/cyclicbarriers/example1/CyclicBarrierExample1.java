package idv.java.ccr.cyclicbarriers.example1;

/**
 * @author Carl Lu
 */
public class CyclicBarrierExample1 {

    public static void main(String[] args) {
        float[][] matrix = new float[3][3];
        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                matrix[row][column] = counter++;
            }
        }
        dump(matrix);
        System.out.println();
        new Solver(matrix);
        System.out.println();
        dump(matrix);
    }

    private static void dump(float[][] matrix) {
        for (float[] aMatrix : matrix) {
            for (int column = 0; column < matrix[0].length; column++) {
                System.out.print(aMatrix[column] + " ");
            }
            System.out.println();
        }
    }

}
