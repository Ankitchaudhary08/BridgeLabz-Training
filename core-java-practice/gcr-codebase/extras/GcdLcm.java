import java.util.Scanner;

public class GcdLcm {

    static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int findLCM(int a, int b) {
        // formula use for lcm
        return (a * b) / findGCD(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("GCD is: " + findGCD(a, b));
        System.out.println("LCM is: " + findLCM(a, b));

        sc.close();
    }
}
