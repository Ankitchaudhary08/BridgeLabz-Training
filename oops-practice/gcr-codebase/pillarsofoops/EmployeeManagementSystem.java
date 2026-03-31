// Interface for Department
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Abstract class Employee
abstract class Employee {

    // Encapsulated fields
    private int employeeId;
    private String name;
    protected double baseSalary; // accessible to child classes

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getter and Setter methods (Encapsulation)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

// Full-Time Employee class
class FullTimeEmployee extends Employee implements Department {

    private String department;

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary; // fixed salary
    }

    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }
}

// Part-Time Employee class
class PartTimeEmployee extends Employee implements Department {

    private int workingHours;
    private String department;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hours) {
        super(id, name, hourlyRate);
        this.workingHours = hours;
    }

    @Override
    public double calculateSalary() {
        return baseSalary * workingHours;
    }

    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }
}

// Main class
public class EmployeeManagementSystem {

    public static void main(String[] args) {

        // Polymorphism: Employee reference
        Employee emp1 = new FullTimeEmployee(101, "Ankit", 50000);
        Employee emp2 = new PartTimeEmployee(102, "Rahul", 500, 40);

        // Assign departments
        Department d1 = (Department) emp1;
        Department d2 = (Department) emp2;

        d1.assignDepartment("IT");
        d2.assignDepartment("Support");

        // Store employees in array
        Employee[] employees = { emp1, emp2 };

        // Process list using Employee reference (Polymorphism)
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Department: "
                    + ((Department) emp).getDepartmentDetails());
            System.out.println("-----------------------");
        }
    }
}
