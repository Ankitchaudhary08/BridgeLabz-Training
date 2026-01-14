package FlightBookingSystem;

public class Types extends Booking {

    public Types(String type, boolean available) {
        super(type, available);
    }

    @Override
    public void ticketCharges() {
        if (type.equals("Economy")) {
            System.out.println("Ticket charge for Economy class is 5000");
        } 
        else if (type.equals("Business")) {
            System.out.println("Ticket charge for Business class is 10000");
        } 
        else {
            System.out.println("Invalid Type");
        }
    }
}
