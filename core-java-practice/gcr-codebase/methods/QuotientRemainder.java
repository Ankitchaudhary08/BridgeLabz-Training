import java.util.Scanner;

public class QuotientRemainder {

    // this method calculate quotient and reminder
    public static int[] findRemainderAndQuotient(int number, int divisor) {

        int quotient = number / divisor;
        int remainder = number % divisor;

        // return both values in array
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking input from user
        System.out.print("Enter number: ");
        int number = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        // calling method
        int[] result = findRemainderAndQuotient(number, divisor);

        // printing final output
        System.out.println("Quotient is " + result[0]);
        System.out.println("Remainder is " + result[1]);

        sc.close();
    }
}
