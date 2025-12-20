import java.util.*;

public class CheckLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int number3 = sc.nextInt();

        // Check which number is largest
        boolean firstIsLargest  = (number1 > number2) && (number1 > number3);
        boolean secondIsLargest = (number2 > number1) && (number2 > number3);
        boolean thirdIsLargest  = (number3 > number1) && (number3 > number2);

        // Output
        System.out.println("Is the first number the largest? " + firstIsLargest);
        System.out.println("Is the second number the largest? " + secondIsLargest);
        System.out.println("Is the third number the largest? " + thirdIsLargest);

        
    }
}
