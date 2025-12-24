import java.util.Random;

public class MatrixOperations {

    // this method create random matrix
    public static int[][] createMatrix(int rows, int cols) {

        int[][] matrix = new int[rows][cols];
        Random rand = new Random();

        // filling matrix with random numbers (1 to 9)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 1 + rand.nextInt(9);
            }
        }
        return matrix;
    }

    // this method add two matrices
    public static int[][] addMatrices(int[][] a, int[][] b) {

        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    // this method subtract two matrices
    public static int[][] subtractMatrices(int[][] a, int[][] b) {

        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    // this method multiply two matrices
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {

        int rows = a.length;
        int cols = b[0].length;
        int common = a[0].length;

        int[][] result = new int[rows][cols];

        // matrix multiplication logic
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // this method print matrix
    public static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int rows = 3;
        int cols = 3;

        // creating random matrices
        int[][] matrixA = createMatrix(rows, cols);
        int[][] matrixB = createMatrix(rows, cols);

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("\nMatrix B:");
        printMatrix(matrixB);

        // addition
        System.out.println("\nAddition of Matrices:");
        int[][] addResult = addMatrices(matrixA, matrixB);
        printMatrix(addResult);

        // subtraction
        System.out.println("\nSubtraction of Matrices (A - B):");
        int[][] subResult = subtractMatrices(matrixA, matrixB);
        printMatrix(subResult);

        // multiplication
        System.out.println("\nMultiplication of Matrices (A x B):");
        int[][] mulResult = multiplyMatrices(matrixA, matrixB);
        printMatrix(mulResult);
    }
}
