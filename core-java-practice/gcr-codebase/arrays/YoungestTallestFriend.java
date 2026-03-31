import java.util.Scanner;

public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arrays to store age and height for 3 friends
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        // Array to store names for easy identification
        String[] names = {"Amar", "Akbar", "Anthony"};

        System.out.println("Enter age and height for Amar, Akbar, and Anthony:");

        // Loop to take user input for age and height
        for (int i = 0; i < names.length; i++) {
            System.out.println("Enter details for " + names[i] + ":");
            System.out.print("Age: ");
            ages[i] = sc.nextInt();
            System.out.print("Height (in cm): ");
            heights[i] = sc.nextDouble();
        }

        // Initialize indices for youngest and tallest assuming the first person is both
        int youngestIndex = 0;
        int tallestIndex = 0;

        // Loop through the array to find the youngest and tallest
        for (int i = 1; i < names.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Finally display the youngest and tallest of the 3 friends
        System.out.println("\nResults:");
        System.out.println("The youngest friend is " + names[youngestIndex] + " with age " + ages[youngestIndex]);
        System.out.println("The tallest friend is " + names[tallestIndex] + " with height " + heights[tallestIndex]);
    }
}