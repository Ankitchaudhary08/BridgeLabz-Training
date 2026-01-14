package FlightBookingSystem;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        int id=sc.nextInt();
        int age=sc.nextInt();

        User user = new User(name,id,age);
        Flight flight = new Flight("AI202", "Delhi", "Mumbai");
        Booking booking = new Types("Economy", true);

        System.out.println("Passenger Name: " + user.getName());

        flight.flightDetails();
        booking.isAvailable();
        booking.ticketCharges();
    }
}

