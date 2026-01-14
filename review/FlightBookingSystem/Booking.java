package FlightBookingSystem;

public abstract class Booking {
    public String type;
    public boolean available;

    public Booking(String type, boolean available) {
        this.type = type;
        this.available = available;
    }

    public void isAvailable() {
        System.out.println("Is Booking Available " + available);
        
    }

    public abstract void ticketCharges();
}
