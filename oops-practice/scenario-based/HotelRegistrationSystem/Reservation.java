package HotelRegistrationSystem;

public class Reservation {

    private Room room;
    private Guest guest;
    private int days;
    private double totalBill;

    public Reservation(Room room, Guest guest, int days) {
        this.room = room;
        this.guest = guest;
        this.days = days;
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public int getDays() {
        return days;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public double getTotalBill() {
        return totalBill;
    }
}
