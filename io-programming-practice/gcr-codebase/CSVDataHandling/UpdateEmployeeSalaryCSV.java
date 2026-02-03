import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateEmployeeSalaryCSV {

    public static void main(String[] args) {

        String inputFile = "employees.csv";
        String outputFile = "employees_updated.csv";
        String line;

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {

            // 1️⃣ Read & write header
            String header = br.readLine();
            bw.write(header);
            bw.newLine();

            // 2️⃣ Process each record
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                // 3️⃣ Increase salary by 10% for IT department
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary * 1.10;
                }

                // 4️⃣ Write updated row to new CSV
                bw.write(
                    data[0] + "," +
                    data[1] + "," +
                    department + "," +
                    (int) salary
                );
                bw.newLine();
            }

            System.out.println("Updated CSV file created successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
