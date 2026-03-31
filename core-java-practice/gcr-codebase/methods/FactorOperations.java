import java.util.Scanner;

public class FactorOperations {

    // this method find all factors and store in array
    public static int[] findFactors(int number) {

        int count = 0;

        // first loop only count the factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;

        // second loop store the factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    // this method find greatest factor
    public static int findGreatestFactor(int[] factors) {
        int max = factors[0];
        for (int f : factors) {
            if (f > max) {
                max = f;
            }
        }
        return max;
    }

    // this method calculate sum of factors
    public static int findSum(int[] factors) {
        int sum = 0;
        for (int f : factors) {
            sum += f;
        }
        return sum;
    }

    // this method calculate product of factors
    public static long findProduct(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= f;
        }
        return product;
    }

    // this method calculate product of cube of factors
    public static double findCubeProduct(int[] factors) {
        double product = 1;
        for (int f : factors) {
            product *= Math.pow(f, 3);
        }
        return product;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking number input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        // printing factors
        System.out.print("Factors are: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }

        System.out.println("\nGreatest Factor: " + findGreatestFactor(factors));
        System.out.println("Sum of Factors: " + findSum(factors));
        System.out.println("Product of Factors: " + findProduct(factors));
        System.out.println("Product of Cube of Factors: " + findCubeProduct(factors));

        sc.close();
    }
}
