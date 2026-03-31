// Node representing a vehicle in the roundabout
public class VehicleNode {

    String vehicleNumber;   // Car number
    VehicleNode next;       // Points to next car (circular)

    // Create a new vehicle
    public VehicleNode(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.next = null;
    }
}
