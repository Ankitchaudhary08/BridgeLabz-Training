import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCSVBySalary {

    // Employee class
    static class Employee {
        String id;
        String name;
        String department;
        int salary;

        Employee(String id, String name, String department, int salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {

        String filePath = "employees.csv";
        String line;
        List<Employee> employees = new ArrayList<>();

        // Step 1: Read CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Employee emp = new Employee(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3])
                );

                employees.add(emp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 2: Sort by salary (Descending order)
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Integer.compare(e2.salary, e1.salary);
            }
        });

        // Step 3: Print top 5 highest-paid employees
        System.out.println("Top 5 Highest-Paid Employees:");
        System.out.println("--------------------------------");

        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            Employee emp = employees.get(i);
            System.out.println(
                    emp.name + " | Dept: " + emp.department +
                    " | Salary: " + emp.salary
            );
        }
    }
}
