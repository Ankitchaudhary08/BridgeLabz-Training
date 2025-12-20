import java.util.Scanner;

public class MultiplicationTableRange {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        System.out.print("Please enter the number for the table: ");
        int inputNumber = userInputScanner.nextInt();

        // Create an array capable of holding the 4 results (for 6, 7, 8, and 9)
        int[] tableData = new int[4];

        // Loop through the specific range 6 to 9 to calculate values
        for (int counter = 6; counter <= 9; counter++) {
            // Calculate index by offsetting the counter
            tableData[counter - 6] = inputNumber * counter;
        }

        // Iterate again to print the stored values in the required format
        for (int counter = 6; counter <= 9; counter++) {
            System.out.println(inputNumber + " * " + counter + " = " + tableData[counter - 6]);
        }
    }
}