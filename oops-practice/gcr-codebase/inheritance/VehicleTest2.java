// Interface
interface Refuelable {
    void refuel();
}

// Superclass
class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// ElectricVehicle subclass
class ElectricVehicle extends Vehicle {

    ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    void charge() {
        System.out.println(model + " is charging.");
    }
}

// PetrolVehicle subclass
class PetrolVehicle extends Vehicle implements Refuelable {

    PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling with petrol.");
    }
}

// Main class
public class VehicleTest2 {
    public static void main(String[] args) {

        Vehicle v1 = new ElectricVehicle(160, "Tesla Model 3");
        Vehicle v2 = new PetrolVehicle(180, "Honda City");

        v1.displayInfo();
        ((ElectricVehicle) v1).charge();   // cast to access charge()

        System.out.println();

        v2.displayInfo();
        ((PetrolVehicle) v2).refuel();     // cast to access refuel()
    }
}
