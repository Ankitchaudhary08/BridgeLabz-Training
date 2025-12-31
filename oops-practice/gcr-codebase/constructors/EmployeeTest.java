// Parent class
class Employee {
    // Access modifiers
    public int employeeID;
    protected String department;
    private double salary;

    // Constructor
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount");
        }
    }

    // Public method to access salary
    public double getSalary() {
        return salary;
    }
}

// Subclass
class Manager extends Employee {

    Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    void displayDetails() {
        System.out.println("Employee ID: " + employeeID);   // public
        System.out.println("Department: " + department);    // protected
        System.out.println("Salary: ₹" + getSalary());       // via public method
    }
}

public class EmployeeTest {
    public static void main(String[] args) {

        Manager m1 = new Manager(101, "IT", 60000);

        m1.displayDetails();

        System.out.println("\nUpdating Salary...");
        m1.setSalary(70000);

        System.out.println("Updated Salary: ₹" + m1.getSalary());
    }
}
