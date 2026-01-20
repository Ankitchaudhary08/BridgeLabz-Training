// Circular Linked List representing the roundabout
public class Roundabout {

    private VehicleNode tail; // Tail helps maintain circular link

    // Add vehicle into roundabout
    public void addVehicle(String vehicleNumber) {

        VehicleNode newNode = new VehicleNode(vehicleNumber);

        // If roundabout is empty
        if (tail == null) {
            tail = newNode;
            tail.next = tail; // circular link
            return;
        }

        // Insert after tail
        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
    }

    // Remove a vehicle from roundabout
    public void removeVehicle() {

        if (tail == null) {
            System.out.println("No vehicles in roundabout.");
            return;
        }

        // Only one vehicle
        if (tail.next == tail) {
            System.out.println("Vehicle exited: " + tail.vehicleNumber);
            tail = null;
            return;
        }

        // Remove head vehicle
        VehicleNode head = tail.next;
        System.out.println("Vehicle exited: " + head.vehicleNumber);
        tail.next = head.next;
    }

    // Print current state of roundabout
    public void printRoundabout() {

        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        System.out.print("Roundabout State: ");
        VehicleNode current = tail.next;

        do {
            System.out.print(current.vehicleNumber + " -> ");
            current = current.next;
        } while (current != tail.next);

        System.out.println("(back to start)");
    }

    // Check if roundabout is empty
    public boolean isEmpty() {
        return tail == null;
    }
}
