import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteEmployeeCSV {

    public static void main(String[] args) {

        String filepath = "employees.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {

            writer.write("Employee ID,Employee Name,Age,Salary");
            writer.newLine();
            writer.write("E001,John Doe,30,50000");
            writer.newLine();
            writer.write("E002,Jane Smith,28,55000");
            writer.newLine();
            writer.write("E003,Bob Johnson,35,60000");

            System.out.println("Employee data written to CSV file successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
