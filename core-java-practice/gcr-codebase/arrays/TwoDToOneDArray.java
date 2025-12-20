import java.util.Scanner;

public class TwoDToOneDArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input for rows and columns
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

        // Create a 2D array (Matrix)
        int[][] matrix = new int[rows][columns];

        System.out.println("Enter elements for the " + rows + "x" + columns + " matrix:");
        // Take the user input
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }

        // Copy the elements of the matrix to a 1D array
        // Create a 1D array of size rows*columns
        int[] array = new int[rows * columns];

        // Define the index variable
        int index = 0;

        // Loop through the 2D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Copy every element of the 2D array into the 1D array and increment the index
                array[index] = matrix[i][j];
                index++;
            }
        }

        System.out.println("\nElements in 1D Array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}