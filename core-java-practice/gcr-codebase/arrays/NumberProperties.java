import java.util.Scanner;

public class NumberProperties {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define an integer array of 5 elements
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");

        // Get user input to store in the array
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\nAnalysis of Numbers:");

        // Loop through the array using the length
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is Negative.");
            } else if (numbers[i] == 0) {
                System.out.println(numbers[i] + " is Zero.");
            } else {
                // Number is positive, check for even or odd
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is Positive and Even.");
                } else {
                    System.out.println(numbers[i] + " is Positive and Odd.");
                }
            }
        }

        // Compare the first and last element of the array
        System.out.println("\nComparison of First and Last Elements:");
        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("The first element is equal to the last element.");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("The first element is greater than the last element.");
        } else {
            System.out.println("The first element is less than the last element.");
        }
    }
}