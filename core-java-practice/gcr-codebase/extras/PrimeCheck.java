import java.util.Scanner;

public class PrimeCheck {

    static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false; // not prime number
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (isPrime(n)) {
            System.out.println("Number is Prime");
        } else {
            System.out.println("Number is Not Prime");
        }

        sc.close();
    }
}
