import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicateCSV {

    public static void main(String[] args) {

        String filePath = "students.csv";
        Set<String> ids = new HashSet<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                String id = data[0];

                if (!ids.add(id)) {
                    System.out.println("Duplicate record found: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
