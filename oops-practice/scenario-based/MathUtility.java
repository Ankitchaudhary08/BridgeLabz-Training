public class MathUtility {

    // 1. Factorial of a number
    public static long factorial(int n) {
        if (n < 0) {
            return -1; // factorial not defined for negative numbers
        }

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    // 2. Check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 3. GCD of two numbers
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 4. Nth Fibonacci number
    public static int fibonacci(int n) {
        if (n < 0) {
            return -1; // invalid input
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // Testing all methods
    public static void main(String[] args) {

        System.out.println("Factorial Tests:");
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Factorial of 0: " + factorial(0));
        System.out.println("Factorial of -3: " + factorial(-3));

        System.out.println("\nPrime Tests:");
        System.out.println("Is 7 prime? " + isPrime(7));
        System.out.println("Is 1 prime? " + isPrime(1));
        System.out.println("Is -5 prime? " + isPrime(-5));

        System.out.println("\nGCD Tests:");
        System.out.println("GCD of 24 and 18: " + gcd(24, 18));
        System.out.println("GCD of -10 and 5: " + gcd(-10, 5));

        System.out.println("\nFibonacci Tests:");
        System.out.println("Fibonacci of 6: " + fibonacci(6));
        System.out.println("Fibonacci of 0: " + fibonacci(0));
        System.out.println("Fibonacci of -2: " + fibonacci(-2));
    }
}
