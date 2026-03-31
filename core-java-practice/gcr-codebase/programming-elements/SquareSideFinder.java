import java.util.Scanner;

public class SquareSideFinder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take perimeter input from user
        System.out.print("Enter the perimeter of the square: ");
        double perimeter = sc.nextDouble();

        
        // Perimeter = 4 × side
        double side = perimeter / 4;

        // Print result
        System.out.println(
            "The length of the side is " + side +
            " whose perimeter is " + perimeter
        );
    }
}
