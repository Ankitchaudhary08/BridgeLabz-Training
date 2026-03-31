import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take base input (in inches)
        System.out.print("Enter base of triangle (in inches): ");
        double base = sc.nextDouble();

        // Take height input (in inches)
        System.out.print("Enter height of triangle (in inches): ");
        double height = sc.nextDouble();

        // Area of triangle formula
        double areaInSquareInches = 0.5 * base * height;

        // Convert square inches to square centimeters
        
        double areaInSquareCm = areaInSquareInches * 2.54 * 2.54;

        // Print result
        System.out.println(
            "The area of the triangle in square inches is " + areaInSquareInches +
            " and in square centimeters is " + areaInSquareCm
        );
    }
}
