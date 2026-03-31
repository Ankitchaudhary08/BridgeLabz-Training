class Employee {

    // this variable store employee name
    String name;

    // this variable store employee id
    int id;

    // this variable store employee salary
    double salary;

    // this method is used to display employee details
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {

        // create employee object
        Employee emp = new Employee();

        // assign value to employee object
        emp.name = "Rohan";
        emp.id = 1;
        emp.salary = 500000;

        // calling display method for show output
        emp.displayDetails();
    }
}
