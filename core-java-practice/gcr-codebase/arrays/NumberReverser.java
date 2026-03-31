import java.util.Scanner;

public class NumberReverser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Find the count of digits in the number
        int temp = number;
        int count = 0;

        if (number == 0) {
            count = 1;
        } else {
            while (temp != 0) {
                temp /= 10;
                count++;
            }
        }

        // Find the digits in the number and save them in an array
        int[] digits = new int[count];
        temp = number;

        if (number == 0) {
            digits[0] = 0;
        } else {
            for (int i = 0; i < count; i++) {
                // Store absolute value of digit to handle negative numbers cleanly
                digits[i] = Math.abs(temp % 10);
                temp /= 10;
            }
        }

        // Create an array to store the elements of the digits array in reverse order
        int[] reversedArray = new int[count];
        for (int i = 0; i < count; i++) {
            reversedArray[i] = digits[count - 1 - i];
        }

        System.out.print("Reversed Number elements: ");
        // Finally, display the elements of the array in reverse order
        for (int i = count - 1; i >= 0; i--) {
            System.out.print(reversedArray[i] + " ");
        }
        System.out.println();
    }
}