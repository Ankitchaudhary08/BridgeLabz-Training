import java.util.Scanner;

public class TriangularParkRun {

    // this method calculate number of rounds for 5km run
    public static double findRounds(double side1, double side2, double side3) {

        // calculating perimeter of tringle
        double perimeter = side1 + side2 + side3;

        // total distance is 5 km means 5000 meters
        double totalDistance = 5000;

        // number of rounds = distance / perimeter
        double rounds = totalDistance / perimeter;

        return rounds;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking side values from user
        System.out.print("Enter first side (in meters): ");
        double a = sc.nextDouble();

        System.out.print("Enter second side (in meters): ");
        double b = sc.nextDouble();

        System.out.print("Enter third side (in meters): ");
        double c = sc.nextDouble();

        // calling method to find rounds
        double result = findRounds(a, b, c);

        // printing final answer
        System.out.println(
                "Athlete needs to complete " +
                result +
                " rounds to finish 5 km run"
        );

        sc.close();
    }
}
