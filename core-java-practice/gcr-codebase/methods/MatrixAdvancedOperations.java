import java.util.Random;

public class MatrixAdvancedOperations {

    // this method create random matrix
    public static double[][] createMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        Random rand = new Random();

        // filling matrix with random value 1 to 9
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 1 + rand.nextInt(9);
            }
        }
        return matrix;
    }

    // this method find transpose of matrix
    public static double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        double[][] transpose = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    // determinant of 2x2 matrix
    public static double determinant2x2(double[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }

    // determinant of 3x3 matrix
    public static double determinant3x3(double[][] m) {
        double det =
                m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
              - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
              + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
        return det;
    }

    // inverse of 2x2 matrix
    public static double[][] inverse2x2(double[][] m) {

        double det = determinant2x2(m);
        if (det == 0) {
            return null; // inverse not possible
        }

        double[][] inv = new double[2][2];

        inv[0][0] =  m[1][1] / det;
        inv[0][1] = -m[0][1] / det;
        inv[1][0] = -m[1][0] / det;
        inv[1][1] =  m[0][0] / det;

        return inv;
    }

    // inverse of 3x3 matrix
    public static double[][] inverse3x3(double[][] m) {

        double det = determinant3x3(m);
        if (det == 0) {
            return null; // inverse not exist
        }

        double[][] inv = new double[3][3];

        inv[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / det;
        inv[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]) / det;
        inv[0][2] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / det;

        inv[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]) / det;
        inv[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / det;
        inv[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]) / det;

        inv[2][0] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / det;
        inv[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]) / det;
        inv[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / det;

        return inv;
    }

    // this method display matrix
    public static void printMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("Inverse not possible");
            return;
        }

        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%8.2f", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // creating random matrices
        double[][] matrix2x2 = createMatrix(2, 2);
        double[][] matrix3x3 = createMatrix(3, 3);

        System.out.println("2x2 Matrix:");
        printMatrix(matrix2x2);

        System.out.println("\nTranspose of 2x2:");
        printMatrix(transposeMatrix(matrix2x2));

        System.out.println("\nDeterminant of 2x2: " + determinant2x2(matrix2x2));

        System.out.println("\nInverse of 2x2:");
        printMatrix(inverse2x2(matrix2x2));

        System.out.println("\n--------------------------------");

        System.out.println("3x3 Matrix:");
        printMatrix(matrix3x3);

        System.out.println("\nTranspose of 3x3:");
        printMatrix(transposeMatrix(matrix3x3));

        System.out.println("\nDeterminant of 3x3: " + determinant3x3(matrix3x3));

        System.out.println("\nInverse of 3x3:");
        printMatrix(inverse3x3(matrix3x3));
    }
}
