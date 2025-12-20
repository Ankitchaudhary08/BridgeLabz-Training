 import java.util.Scanner;

public class SumOfNaturalNumbersWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a valid natural number.");
        } else {
            // Using while loop
            int sumLoop = 0;
            int counter = 1;

            while (counter <= n) {
                sumLoop = sumLoop + counter;
                counter++;
            }

            // Using formula
            int sumFormula = n * (n + 1) / 2;

            // Output
            System.out.println("Sum using while loop: " + sumLoop);
            System.out.println("Sum using formula: " + sumFormula);

            if (sumLoop == sumFormula) {
                System.out.println("Result is correct. Both computations match.");
            } else {
                System.out.println("Result is incorrect. Computations do not match.");
            }
        }
    }

    
}
