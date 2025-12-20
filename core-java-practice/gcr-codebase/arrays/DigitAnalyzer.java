import java.util.Scanner;

public class DigitAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a number variable and Take user input
        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        // Define an array to store the digits. Set the size of the array to maxDigit variable initially set to 10
        int maxDigit = 10;
        int[] digits = new int[maxDigit];

        // Create an integer variable index with the value 0 to reflect the array index
        int index = 0;

        // Use a loop to iterate until the number is not equal to 0
        // Using Math.abs to handle negative numbers correctly
        long tempNumber = Math.abs(number);
        
        // Handle the case for 0 explicitly if needed, though loop condition covers non-zero
        if (tempNumber == 0) {
            digits[index] = 0;
            index++;
        } else {
            while (tempNumber != 0) {
                // Remove the last digit from the number in each iteration and add it to the array
                digits[index] = (int) (tempNumber % 10);
                
                // Increment the index by 1 in each iteration
                index++;
                
                // If the index count equals maxDigit, increase maxDigit and resize array
                if (index == maxDigit) {
                    maxDigit += 10;
                    int[] temp = new int[maxDigit];
                    for (int i = 0; i < digits.length; i++) {
                        temp[i] = digits[i];
                    }
                    digits = temp;
                }
                
                tempNumber = tempNumber / 10;
            }
        }

        // Define variable to store largest and second largest digit and initialize it to zero
        int largest = 0;
        int secondLargest = 0;

        // Loop through the array and use conditional statements to find the largest and second largest number
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Finally display the largest and second-largest number
        System.out.println("Largest Digit: " + largest);
        System.out.println("Second Largest Digit: " + secondLargest);
    }
}