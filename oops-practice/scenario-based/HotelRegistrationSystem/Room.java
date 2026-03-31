package HotelRegistrationSystem;

public abstract class Room {

    protected int roomNumber;
    protected boolean isAvailable = true;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkIn() {
        isAvailable = false;
    }

    public void checkOut() {
        isAvailable = true;
    }

    // Polymorphism
    public abstract double getBasePrice();
}
