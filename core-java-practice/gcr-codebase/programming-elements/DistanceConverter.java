import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take distance in feet from user
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = sc.nextDouble();

        // Convert feet to yards
        // 1 yard = 3 feet
        double distanceInYards = distanceInFeet / 3;

        // Convert yards to miles
        // 1 mile = 1760 yards
        double distanceInMiles = distanceInYards / 1760;

        // Print result
        System.out.println(
            "Your distance in feet is " + distanceInFeet +
            ", in yards is " + distanceInYards +
            " and in miles is " + distanceInMiles
        );
    }
}
