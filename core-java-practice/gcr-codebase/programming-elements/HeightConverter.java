import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take height in centimeters
        System.out.print("Enter your height in centimeters: ");
        double heightCm = sc.nextDouble();

        // Convert cm to inches
        double totalInches = heightCm / 2.54;

        // Calculate feet
        int feet = (int) (totalInches / 12);

        // Calculate remaining inches
        double inches = totalInches % 12;

        // Print result
        System.out.println(
            "Your Height in cm is " + heightCm +
            " while in feet is " + feet +
            " and inches is " + inches
        );
    }
}
