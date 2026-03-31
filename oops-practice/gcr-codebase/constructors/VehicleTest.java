class Vehicle {
    // Instance variables (unique for each vehicle)
    String ownerName;
    String vehicleType;

    // Class variable (same for all vehicles)
    static double registrationFee = 5000;

    // Constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    // Class (static) method
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

public class VehicleTest {
    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("Ankit", "Car");
        Vehicle v2 = new Vehicle("Rahul", "Bike");

        v1.displayVehicleDetails();
        System.out.println();

        v2.displayVehicleDetails();
        System.out.println();

        // Update registration fee for all vehicles
        Vehicle.updateRegistrationFee(6500);

        System.out.println("After Registration Fee Update:\n");
        v1.displayVehicleDetails();
    }
}
