import java.util.*;

// Custom Exception 
class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}

// Table Class 
class Table {
    private int tableNumber;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }
}

//  Reservation Class 
class Reservation {
    private int tableNumber;
    private String timeSlot;
    private String customerName;

    public Reservation(int tableNumber, String timeSlot, String customerName) {
        this.tableNumber = tableNumber;
        this.timeSlot = timeSlot;
        this.customerName = customerName;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return "Table " + tableNumber + " | Time: " + timeSlot +
               " | Customer: " + customerName;
    }
}

// Reservation System 
class RestaurantReservationSystem {

    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    // Add tables to restaurant
    public void addTable(int tableNumber) {
        tables.put(tableNumber, new Table(tableNumber));
    }

    // Reserve a table
    public void reserveTable(int tableNumber, String timeSlot, String customerName)
            throws TableAlreadyReservedException {

        if (!tables.containsKey(tableNumber)) {
            System.out.println("Table does not exist");
            return;
        }

        // Check for double booking
        for (Reservation r : reservations) {
            if (r.getTableNumber() == tableNumber &&
                r.getTimeSlot().equals(timeSlot)) {

                throw new TableAlreadyReservedException(
                        "Table " + tableNumber + " already reserved for " + timeSlot);
            }
        }

        reservations.add(new Reservation(tableNumber, timeSlot, customerName));
        System.out.println("Reservation successful for Table " + tableNumber);
    }

    // Cancel reservation
    public void cancelReservation(int tableNumber, String timeSlot) {
        Iterator<Reservation> iterator = reservations.iterator();

        while (iterator.hasNext()) {
            Reservation r = iterator.next();
            if (r.getTableNumber() == tableNumber &&
                r.getTimeSlot().equals(timeSlot)) {

                iterator.remove();
                System.out.println("Reservation cancelled for Table " + tableNumber);
                return;
            }
        }
        System.out.println("No reservation found to cancel");
    }

    // Show available tables for a time slot
    public void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");

        for (int tableNumber : tables.keySet()) {
            boolean isReserved = false;

            for (Reservation r : reservations) {
                if (r.getTableNumber() == tableNumber &&
                    r.getTimeSlot().equals(timeSlot)) {
                    isReserved = true;
                    break;
                }
            }

            if (!isReserved) {
                System.out.println("Table " + tableNumber);
            }
        }
    }
}

//  Main Class
public class RestaurantTableReservationSystem {
    public static void main(String[] args) {

        RestaurantReservationSystem system = new RestaurantReservationSystem();

        // Add tables
        system.addTable(1);
        system.addTable(2);
        system.addTable(3);

        try {
            system.reserveTable(1, "6PM-7PM", "Ankit");
            system.reserveTable(2, "6PM-7PM", "Ravi");

            // Double booking (exception)
            system.reserveTable(1, "6PM-7PM", "Amit");
        } catch (TableAlreadyReservedException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Show available tables
        system.showAvailableTables("6PM-7PM");

        // Cancel reservation
        system.cancelReservation(1, "6PM-7PM");

        // Show again
        system.showAvailableTables("6PM-7PM");
    }
}
