package algorithms.arrays.ZeroMatrix;

public class ZeroMatrix {

    private int[][] ZeroMatrix(int[][] matrix) {

        int[] x = new int[matrix[0].length];
        int[] y = new int[matrix.length];

        // O(n^2)
        //

        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    x[i] = 1;
                    y[j] = 1;
                    break;
                }

            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                if (x[i] == 1) {
                    temp[i][j] = 0;
                } else if (y[j] == 1) {
                    temp[i][j] = 0;
                } else {
                    temp[i][j] = matrix[i][j];
                }
            }
        }

        return temp;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void runTests() {
        int[][] testMatrix1 = { {1, 2, 3, 4}, {1, 0, 3, 4}, {0, 2, 3, 4}, {1, 2, 3, 4} };
        int[][] resultMatrix1 = ZeroMatrix(testMatrix1);
        printMatrix(resultMatrix1);
    }

}
