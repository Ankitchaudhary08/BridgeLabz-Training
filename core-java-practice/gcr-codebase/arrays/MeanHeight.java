import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a double array named heights of size 11
        double[] heights = new double[11];
        double sum = 0;

        System.out.println("Enter the heights of 11 football players:");

        // Get input values from the user
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height for player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }

        // Find the sum of all the elements present in the array
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }

        // Divide the sum by 11 to find the mean height
        double mean = sum / 11;

        // Print the mean height of the football team
        System.out.println("Mean height of the football team: " + mean);
    }
}