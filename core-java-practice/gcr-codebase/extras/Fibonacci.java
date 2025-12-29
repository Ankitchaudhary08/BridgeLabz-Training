import java.util.Scanner;

public class Fibonacci {

    static void printFibonacci(int terms) {
        int a = 0, b = 1;
        // print fibonacci till given terms
        for (int i = 1; i <= terms; i++) {
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int terms = sc.nextInt();

        printFibonacci(terms);
        sc.close();
    }
}
