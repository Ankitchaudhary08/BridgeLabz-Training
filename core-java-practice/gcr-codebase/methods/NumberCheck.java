import java.util.Scanner;

public class NumberCheck {

    // this method check the number sign
    public static int checkValue(int num) {

        if (num > 0) {
            return 1;   // number is positive
        } else if (num < 0) {
            return -1;  // number is nagative
        } else {
            return 0;   // number is zero
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking integer input from user
        System.out.print("Enter a number: ");
        int value = sc.nextInt();

        // calling method to get result
        int result = checkValue(value);

        // displaying result based on return value
        if (result == 1) {
            System.out.println("The number is Positive");
        } else if (result == -1) {
            System.out.println("The number is Negative");
        } else {
            System.out.println("The number is Zero");
        }

        sc.close();
    }
}
