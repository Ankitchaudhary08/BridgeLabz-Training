class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    // Default constructor
    HotelBooking() {
        guestName = "Not Assigned";
        roomType = "Standard";
        nights = 1;
    }

    // Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }

    void display() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }
}

public class HotelBookingTest {
    public static void main(String[] args) {

        // Default booking
        HotelBooking b1 = new HotelBooking();

        // Parameterized booking
        HotelBooking b2 = new HotelBooking("Ankit", "Deluxe", 3);

        // Copy booking
        HotelBooking b3 = new HotelBooking(b2);

        System.out.println("Default Booking:");
        b1.display();

        System.out.println("\nParameterized Booking:");
        b2.display();

        System.out.println("\nCopied Booking:");
        b3.display();
    }
}
