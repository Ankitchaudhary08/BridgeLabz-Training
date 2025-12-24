import java.util.Scanner;

public class NumberFactors {

    // this method find all factors and store in array
    public static int[] findFactors(int num) {

        int count = 0;

        // first loop for counting factors
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;

        // second loop for storing factors
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    // this method calculate sum of factors
    public static int findSum(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    // this method calculate product of factors
    public static long findProduct(int[] arr) {
        long product = 1;
        for (int value : arr) {
            product *= value;
        }
        return product;
    }

    // this method calculate sum of square of factors
    public static double findSumOfSquares(int[] arr) {
        double sum = 0;
        for (int value : arr) {
            sum += Math.pow(value, 2);
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking number from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        // displaying factors
        System.out.print("Factors are: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }

        System.out.println("\nSum of factors: " + findSum(factors));
        System.out.println("Product of factors: " + findProduct(factors));
        System.out.println("Sum of square of factors: " + findSumOfSquares(factors));

        sc.close();
    }
}
