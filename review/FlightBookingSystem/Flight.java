package FlightBookingSystem;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;

    public Flight(String flightNumber, String origin, String destination) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
    }

    public void flightDetails() {
        System.out.println("Flight No: " + flightNumber);
        System.out.println("From: " + origin + " To: " + destination);
    }
}
