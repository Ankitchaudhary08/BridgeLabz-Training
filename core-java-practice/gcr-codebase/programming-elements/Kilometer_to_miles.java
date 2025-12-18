import java.util.Scanner; // Import Scanner for input

public class Kilometer_to_miles {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 

        //  distance in KM
        System.out.print("Enter distance in kilometers: ");
        double kilometers = sc.nextDouble();

        
        // 1 kilometer = 0.621371 miles
        double miles = kilometers * 0.621371;

        // output
        System.out.println("Distance in miles: " + miles);
    }
}
