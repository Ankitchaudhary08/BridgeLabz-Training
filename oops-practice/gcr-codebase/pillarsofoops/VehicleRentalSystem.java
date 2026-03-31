// Insurance Interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Vehicle class
abstract class Vehicle {

    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation: getters
    public double getRentalRate() {
        return rentalRate;
    }

    public String getType() {
        return type;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);
}

// Car class
class Car extends Vehicle implements Insurable {

    private String policyNumber;

    public Car(String number, double rate, String policyNumber) {
        super(number, "Car", rate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 500;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance | Policy No: " + policyNumber;
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {

    private String policyNumber;

    public Bike(String number, double rate, String policyNumber) {
        super(number, "Bike", rate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 200;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance | Policy No: " + policyNumber;
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {

    private String policyNumber;

    public Truck(String number, double rate, String policyNumber) {
        super(number, "Truck", rate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 1000;
    }

    @Override
    public double calculateInsurance() {
        return 1000;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance | Policy No: " + policyNumber;
    }
}

// Main class
public class VehicleRentalSystem {

    public static void main(String[] args) {

        Vehicle v1 = new Car("CAR101", 2000, "CAR-INS-01");
        Vehicle v2 = new Bike("BIKE202", 800, "BIKE-INS-02");
        Vehicle v3 = new Truck("TRK303", 5000, "TRK-INS-03");

        Vehicle[] vehicles = { v1, v2, v3 };

        int days = 3;

        for (Vehicle v : vehicles) {
            double rent = v.calculateRentalCost(days);
            double insurance = ((Insurable) v).calculateInsurance();

            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Rental Cost: " + rent);
            System.out.println("Insurance Cost: " + insurance);
            System.out.println("-----------------------");
        }
    }
}
