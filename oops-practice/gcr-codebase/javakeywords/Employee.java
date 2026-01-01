class Employee {

    // Static variables
    static String companyName = "Tech Solutions Inc.";
    static int totalEmployees = 0;

    // Instance variables
    final int id;          // final variable
    String name;
    String designation;

    // Constructor using this
    Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    // Static method
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method using instanceof
    void displayDetails(Object obj) {
        if (obj instanceof Employee) {
            Employee e = (Employee) obj;
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + e.id);
            System.out.println("Name: " + e.name);
            System.out.println("Designation: " + e.designation);
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {

        Employee e1 = new Employee(101, "Thamarai", "Software Engineer");
        Employee e2 = new Employee(102, "Rohan", "Project Manager");

        displayTotalEmployees();

        e1.displayDetails(e1);
        e2.displayDetails(e2);
    }
}
