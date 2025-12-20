import java.util.*;
public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        // Check if the number is a natural number (positive integer)
        if (n > 0) {
            // Compute using formula
            int sumFormula = n * (n + 1) / 2;
            // Compute using for loop
            int sumLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumLoop += i;
            }
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using for loop: " + sumLoop);
            if (sumFormula == sumLoop) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("Computations do not match.");
            }
        } else {
            System.out.println("The number " + n + " is not a natural number.");
        }

    }
}