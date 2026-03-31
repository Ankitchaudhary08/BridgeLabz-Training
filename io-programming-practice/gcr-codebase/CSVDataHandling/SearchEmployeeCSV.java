import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployeeCSV {

    public static void main(String[] args) {

        String filePath = "employees.csv";
        Scanner scanner = new Scanner(System.in);
        String line;
        boolean found = false;

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Step 1: Skip header
            br.readLine();

            // Step 2: Read records
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[1];

                // Step 3: Compare names (case-insensitive)
                if (name.equalsIgnoreCase(searchName)) {

                    System.out.println("Employee Found!");
                    System.out.println("Name       : " + name);
                    System.out.println("Department : " + data[2]);
                    System.out.println("Salary     : " + data[3]);

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
