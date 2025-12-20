import java.util.*;
public class SumOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a variable to store an array of 10 elements of type double
        double[] numbers = new double[10];
        
        // Variable to store the total of type double initializes to 0.0
         double total = 0.0;
        
        // Index variable is initialized to 0 for the array
        int index = 0;
        System.out.println("Enter numbers (enter 0 or negative number to stop, max 10 numbers):");
        // Use infinite while loop
        while (true) {
            // Break from the loop if the index has a value of 10
            if (index == 10) {
                break;
            }

            System.out.print("Enter number: ");
            double input = sc.nextDouble();

            // Check if the user entered 0 or a negative number to break the loop
            if (input <= 0) {
                break;
            }
            // Assign the number to the array element and increment the index value
            numbers[index] = input;
            index++;
        }
        System.out.println("\nEntered Numbers:");
        // Take another for loop to get the values of each element and add it to the total
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        // Finally display the total value
        System.out.println("Total Sum: " + total);
    }
}