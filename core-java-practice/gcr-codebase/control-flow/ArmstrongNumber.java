import java.util.*;
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get an integer input and store it in the number variable
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Define sum variable, initialize it to zero
        int sum = 0;
        // Define originalNumber variable and assign it to input number variable
        int originalNumber = number;

        // Use the while loop till the originalNumber is not equal to zero
        while (originalNumber != 0) {
            // Find each digit which is the reminder of the modulus operation number % 10
            int remainder = originalNumber % 10;
            
            // Find the cube of the number and add it to the sum variable
            sum += remainder * remainder * remainder;
            
            // Find the quotient of the number using the division operation number/10 and assign it to the original number
            originalNumber /= 10;
        }

        // Check if the number and the sum are the same
        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        
    }
}