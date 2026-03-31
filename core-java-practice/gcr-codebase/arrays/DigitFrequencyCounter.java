import java.util.Scanner;

public class DigitFrequencyCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Take input number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        int digitCount = 0;

        // Step 2: Find count of digits
        while (temp != 0) {
            digitCount++;
            temp = temp / 10;
        }

        // Step 3: Store digits in an array
        int[] digits = new int[digitCount];
        temp = number;

        for (int i = digitCount - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }

        // Step 4: Frequency array of size 10 (0–9)
        int[] frequency = new int[10];

        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }

        // Step 5: Display frequency
        System.out.println("\nDigit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " : " + frequency[i] + " time(s)");
            }
        }

        sc.close();
    }
}
