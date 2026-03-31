import java.util.Scanner;

public class FirstIsSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int number3 = sc.nextInt();

        // Check if first number is the smallest
        boolean isSmallest = (number1 < number2) && (number1 < number3);

        // Output result
        System.out.println("Is the first number the smallest? " + isSmallest);

       
    }
}
