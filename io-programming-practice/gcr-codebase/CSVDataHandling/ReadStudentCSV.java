import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadStudentCSV {

    public static void main(String[] args) {

        String filePath = "C:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\CSVDataHandling\\Student.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Step 1: Skip header line
            br.readLine();

            // Step 2: Read each record
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String age = data[2];
                String marks = data[3];

                // Step 3: Print in structured format
                System.out.println("Student ID   : " + id);
                System.out.println("Student Name : " + name);
                System.out.println("Age          : " + age);
                System.out.println("Marks        : " + marks);
                System.out.println("---------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
