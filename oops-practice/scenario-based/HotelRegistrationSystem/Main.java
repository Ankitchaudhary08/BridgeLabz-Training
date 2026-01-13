package HotelRegistrationSystem;

public class Main {

    public static void main(String[] args) {

        PricingStrategy pricing = new SeasonalPricing();
        HotelService hotelService = new HotelService(pricing);

        Room room1 = new StandardRoom(101);
        Room room2 = new DeluxeRoom(201);

        hotelService.addRoom(room1);
        hotelService.addRoom(room2);

        Guest guest = new Guest(1, "Ankit");

        try {
            Reservation reservation =
                    hotelService.bookRoom(room2, guest, 3);
            hotelService.checkOut(reservation);
        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}

