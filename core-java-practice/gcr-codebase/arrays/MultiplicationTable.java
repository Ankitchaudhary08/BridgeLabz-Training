import java.util.*;
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Define an integer array to store the results of multiplication from 1 to 10
        int[] multiplicationResults = new int[10];

        // Run a loop from 1 to 10 and store the results in the multiplication table array
        // We use (i - 1) for the index because arrays are 0-indexed
        for (int i = 1; i <= 10; i++) {
            multiplicationResults[i - 1] = number * i;
        }

        System.out.println("Multiplication Table for " + number + ":");

        // Finally, display the result from the array in the format number * i = ___
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResults[i - 1]);
        }
    }
}