class Patient {

    // Static variables
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    // Instance variables
    final String patientID;   // final variable
    String name;
    int age;
    String ailment;

    // Constructor using this
    Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    // Static method
    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Method using instanceof
    void displayDetails(Object obj) {
        if (obj instanceof Patient) {
            Patient p = (Patient) obj;
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + p.patientID);
            System.out.println("Name: " + p.name);
            System.out.println("Age: " + p.age);
            System.out.println("Ailment: " + p.ailment);
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {

        Patient p1 = new Patient("P001", "Lathika", 30, "Flu");
        Patient p2 = new Patient("P002", "Lidiya", 45, "Fracture");

        getTotalPatients();

        p1.displayDetails(p1);
        p2.displayDetails(p2);
    }
}
