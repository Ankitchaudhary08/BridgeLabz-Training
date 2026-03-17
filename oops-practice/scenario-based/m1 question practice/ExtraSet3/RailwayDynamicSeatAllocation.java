import java.util.*;

public class RailwayDynamicSeatAllocation {

    static class Booking {
        String passengerId;
        int seatCount;
        double bookingFare;

        Booking(String passengerId, int seatCount, double bookingFare) {
            this.passengerId = passengerId;
            this.seatCount = seatCount;
            this.bookingFare = bookingFare;
        }
    }

    static class Train {
        String trainId, source, destination;
        int totalSeats, availableSeats;
        double baseFare;
        List<Booking> bookings = new ArrayList<>();

        Train(String trainId, String source, String destination, int totalSeats, double baseFare) {
            this.trainId = trainId;
            this.source = source;
            this.destination = destination;
            this.totalSeats = totalSeats;
            this.availableSeats = totalSeats;
            this.baseFare = baseFare;
        }
    }

    static List<Train> trains = new ArrayList<>();

    static Train findTrain(String trainId) {
        for (Train t : trains) if (t.trainId.equals(trainId)) return t;
        return null;
    }

    static void addTrain(String trainId, String source, String destination, int totalSeats, double baseFare) {
        if (findTrain(trainId) == null) {
            trains.add(new Train(trainId, source, destination, totalSeats, baseFare));
        }
    }

    static void bookSeats(String trainId, String passengerId, int seatCount) {
        Train train = findTrain(trainId);
        if (train == null || train.availableSeats < seatCount) {
            System.out.println("Booking failed");
            return;
        }
        // bookingFare = (seatCount × baseFare) + (seatCount × 25)
        double fare = (seatCount * train.baseFare) + (seatCount * 25);
        train.availableSeats -= seatCount;
        train.bookings.add(new Booking(passengerId, seatCount, fare));
        System.out.println("BOOKED " + trainId + " " + passengerId + " " + (long) fare);
    }

    static void cancelBooking(String trainId, String passengerId) {
        Train train = findTrain(trainId);
        if (train == null) {
            System.out.println("Cancellation failed");
            return;
        }
        Booking toRemove = null;
        for (Booking b : train.bookings) {
            if (b.passengerId.equals(passengerId)) {
                toRemove = b;
                break;
            }
        }
        if (toRemove == null) {
            System.out.println("Cancellation failed");
            return;
        }
        train.availableSeats += toRemove.seatCount;
        train.bookings.remove(toRemove);
        System.out.println("CANCELLED " + trainId + " " + passengerId);
    }

    static void findRoute(String source, String destination) {
        boolean found = false;
        for (Train t : trains) {
            if (t.source.equals(source) && t.destination.equals(destination)) {
                System.out.println(t.trainId + " " + t.availableSeats);
                found = true;
            }
        }
        if (!found) System.out.println("No trains available");
    }

    static void summary() {
        for (Train t : trains) {
            double total = 0;
            for (Booking b : t.bookings) total += b.bookingFare;
            System.out.println(t.trainId + " " + (long) total);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");
            String cmd = parts[0];

            if (cmd.equals("ADDTRAIN")) {
                addTrain(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Double.parseDouble(parts[5]));
            } else if (cmd.equals("BOOK")) {
                bookSeats(parts[1], parts[2], Integer.parseInt(parts[3]));
            } else if (cmd.equals("CANCEL")) {
                cancelBooking(parts[1], parts[2]);
            } else if (cmd.equals("ROUTE")) {
                findRoute(parts[1], parts[2]);
            } else if (cmd.equals("SUMMARY")) {
                summary();
            }
        }
        sc.close();
    }
}
