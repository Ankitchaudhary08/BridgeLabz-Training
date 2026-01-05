// GPS interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

// Abstract Vehicle class
abstract class Vehicle {

    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Encapsulation: getters
    public double getRatePerKm() {
        return ratePerKm;
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
    }
}

// Car class
class Car extends Vehicle implements GPS {

    private String location = "Unknown";

    public Car(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) + 50; // base charge
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Bike class
class Bike extends Vehicle implements GPS {

    private String location = "Unknown";

    public Bike(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Auto class
class Auto extends Vehicle implements GPS {

    private String location = "Unknown";

    public Auto(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) + 20;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Main class
public class RideHailingApplication {

    // Polymorphic method
    public static void calculateRideFare(Vehicle vehicle, double distance) {

        vehicle.getVehicleDetails();
        double fare = vehicle.calculateFare(distance);

        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: " + fare);

        GPS gps = (GPS) vehicle;
        System.out.println("Location: " + gps.getCurrentLocation());
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        Vehicle v1 = new Car("CAR101", "Ankit", 15);
        Vehicle v2 = new Bike("BIKE202", "Rahul", 8);
        Vehicle v3 = new Auto("AUTO303", "Amit", 10);

        calculateRideFare(v1, 10);
        calculateRideFare(v2, 10);
        calculateRideFare(v3, 10);
    }
}
