import java.util.Scanner;

public class NaturalNumberSum {

    // this method find sum of n natural number using loop
    public static int calculateSum(int n) {

        int total = 0;

        // loop will add number one by one
        for (int i = 1; i <= n; i++) {
            total = total + i;
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking number from user
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        // calling method to calculate sum
        int sumResult = calculateSum(n);

        // printing final result
        System.out.println("Sum of first " + n + " natural numbers is " + sumResult);

        sc.close();
    }
}
