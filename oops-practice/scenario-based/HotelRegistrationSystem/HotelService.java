package HotelRegistrationSystem;

import java.util.ArrayList;
import java.util.List;

public class HotelService {

    private List<Room> rooms = new ArrayList<>();
    private PricingStrategy pricingStrategy;

    public HotelService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Reservation bookRoom(Room room, Guest guest, int days)
            throws RoomNotAvailableException {

        if (!room.isAvailable()) {
            throw new RoomNotAvailableException("Room is not available");
        }

        room.checkIn();

        Reservation reservation = new Reservation(room, guest, days);
        double bill = pricingStrategy.calculatePrice(room, days);
        reservation.setTotalBill(bill);

        System.out.println("Room booked for " + guest.getName());
        return reservation;
    }

    public void checkOut(Reservation reservation) {
        reservation.getRoom().checkOut();
        System.out.println("Check-out completed. Bill: ₹" +
                reservation.getTotalBill());
    }
}
