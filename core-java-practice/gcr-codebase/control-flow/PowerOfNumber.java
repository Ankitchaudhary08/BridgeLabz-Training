import java.util.Scanner;

public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base number: ");
        int number = scanner.nextInt();

        System.out.print("Enter the power: ");
        int power = scanner.nextInt();

        if (number > 0 && power > 0) {
            long result = 1;
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            System.out.println(number + " to the power of " + power + " is " + result);
        } else {
            System.out.println("Please enter positive integers for both base and power.");
        }
    }
}