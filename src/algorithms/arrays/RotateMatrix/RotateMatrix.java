package algorithms.arrays.RotateMatrix;

public class RotateMatrix {

    private int[][] RotateMatrix(int[][] matrix) {
        int[][] temp = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != temp[i].length) {
                System.out.println("Matrix is not NxN");
                return new int[][]{};
            }
            for (int j = matrix.length - 1; j >= 0;  j--) {
                temp[i][j] = matrix[(matrix.length - 1) - j][i];

            }
        }

        return temp;
    }

    private int[][] BookRotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            System.out.println("Matrix is not NxN");
            return new int[][]{};
        }
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // Save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];

                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        return matrix;
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
        int[][] testMatrix1 = new int[][] { {1, 2, 3}, {1, 2, 3}, {1, 2,3}};
        int[][] resultMatrix1 = BookRotateMatrix(testMatrix1);
        printMatrix(resultMatrix1);
    }
}
