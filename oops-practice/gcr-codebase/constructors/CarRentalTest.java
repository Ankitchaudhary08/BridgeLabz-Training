class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double totalCost;

    // Default constructor
    CarRental() {
        customerName = "Not Assigned";
        carModel = "Basic";
        rentalDays = 1;
        calculateCost();
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        calculateCost();
    }

    // Method to calculate total cost
    void calculateCost() {
        double costPerDay = 1500; // INR per day
        totalCost = rentalDays * costPerDay;
    }

    void display() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + totalCost);
    }
}

public class CarRentalTest {
    public static void main(String[] args) {

        // Default rental
        CarRental r1 = new CarRental();

        // Parameterized rental
        CarRental r2 = new CarRental("Ankit", "Swift", 3);

        System.out.println("Default Rental:");
        r1.display();

        System.out.println("\nCustomer Rental:");
        r2.display();
    }
}
