import java.io.*;
import java.util.ArrayList;

// Main class
public class EmployeeSerialization {

    public static void main(String[] args) {

        // Create list of employees
        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Ankit", "IT", 50000));
        empList.add(new Employee(2, "Rahul", "HR", 40000));
        empList.add(new Employee(3, "Aman", "Finance", 45000));

        // SERIALIZATION 
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream("employees.dat"));

            oos.writeObject(empList);
            oos.close();

            System.out.println("Employees saved successfully.");

        } catch (IOException e) {
            System.out.println("Error while saving employees.");
            e.printStackTrace();
        }

        //  DESERIALIZATION 
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("employees.dat"));

            ArrayList<Employee> list =
                    (ArrayList<Employee>) ois.readObject();

            ois.close();

            System.out.println("\nEmployees retrieved from file:");
            for (Employee emp : list) {
                emp.display();
            }

        } catch (IOException e) {
            System.out.println("IO Error while reading employees.");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
            e.printStackTrace();
        }
    }
}

// Employee class (Serializable)
class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println(
                "ID: " + id +
                ", Name: " + name +
                ", Dept: " + department +
                ", Salary: " + salary
        );
    }
}
