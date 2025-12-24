import java.util.Scanner;

public class NaturalNumberSumCompare {

    // this method find sum using recursion
    public static int recursiveSum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + recursiveSum(n - 1);
    }

    // this method find sum using formula
    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking number from user
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a valid natural number");
        } else {
            int sum1 = recursiveSum(n);
            int sum2 = formulaSum(n);

            System.out.println("Sum using recursion: " + sum1);
            System.out.println("Sum using formula: " + sum2);

            if (sum1 == sum2) {
                System.out.println("Both results are correct");
            }
        }

        sc.close();
    }
}
