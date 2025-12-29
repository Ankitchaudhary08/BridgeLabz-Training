import java.util.Scanner;

public class BusRouteTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalDistance = 0;
        int stopDistance = 5; // each stop add 5 km
        String choice = "no";

        // loop runs until passenger get off
        while (choice.equalsIgnoreCase("no")) {

            totalDistance = totalDistance + stopDistance;
            System.out.println("Bus stopped. Total distance till now: " + totalDistance + " km");

            // ask passenger
            System.out.print("Do you want to get off? (yes/no): ");
            choice = sc.next();

            // small check for safety
            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("You got off the bus.");
                break;
            }
        }

        System.out.println("Final Distance Travelled: " + totalDistance + " km");

        // program end here
        sc.close();
    }
}
