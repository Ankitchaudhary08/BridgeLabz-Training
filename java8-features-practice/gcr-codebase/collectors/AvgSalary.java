import java.util.*;
import java.util.stream.*;

class Employee {
    String dept;
    double salary;

    Employee(String dept, double salary) {
        this.dept = dept;
        this.salary = salary;
    }

    String getDepartment() { return dept; }
    double getSalary() { return salary; }
}

public class AvgSalary {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
            new Employee("IT", 50000),
            new Employee("IT", 70000),
            new Employee("HR", 40000)
        );

        Map<String, Double> avgSalaryByDept =
            employees.stream()
                     .collect(Collectors.groupingBy(
                         Employee::getDepartment,
                         Collectors.averagingDouble(Employee::getSalary)
                     ));

        System.out.println(avgSalaryByDept);
    }
}
