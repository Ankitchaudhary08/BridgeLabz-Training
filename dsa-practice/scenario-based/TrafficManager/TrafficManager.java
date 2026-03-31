// Main class to simulate smart traffic system
public class TrafficManager {

    public static void main(String[] args) {

        Roundabout roundabout = new Roundabout();
        WaitingQueue waitingQueue = new WaitingQueue(3);

        // Vehicles arriving
        waitingQueue.enqueue("CAR-101");
        waitingQueue.enqueue("CAR-102");
        waitingQueue.enqueue("CAR-103");
        waitingQueue.enqueue("CAR-104"); // overflow

        // Move vehicles from queue to roundabout
        while (!waitingQueue.isEmpty()) {
            String car = waitingQueue.dequeue();
            if (car != null) {
                roundabout.addVehicle(car);
            }
        }

        roundabout.printRoundabout();

        // Vehicles exiting
        roundabout.removeVehicle();
        roundabout.printRoundabout();

        roundabout.removeVehicle();
        roundabout.printRoundabout();

        roundabout.removeVehicle();
        roundabout.printRoundabout();

        // Underflow check
        roundabout.removeVehicle();
    }
}
