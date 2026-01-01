class Vehicle {

    // Static variable
    static double registrationFee = 150.0;

    // Instance variables
    final String registrationNumber;   // final variable
    String ownerName;
    String vehicleType;

    // Constructor using this
    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Method using instanceof
    void displayDetails(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle v = (Vehicle) obj;
            System.out.println("Owner Name: " + v.ownerName);
            System.out.println("Vehicle Type: " + v.vehicleType);
            System.out.println("Registration Number: " + v.registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("Honest raj", "Sedan", "ABC123");
        Vehicle v2 = new Vehicle("Price danish", "SUV", "XYZ789");

        v1.displayDetails(v1);
        v2.displayDetails(v2);
    }
}
