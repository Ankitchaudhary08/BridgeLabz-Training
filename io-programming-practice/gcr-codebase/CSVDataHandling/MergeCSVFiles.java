import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {

    public static void main(String[] args) {

        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "students_merged.csv";

        // Map to store ID -> Name,Age
        Map<String, String[]> studentInfoMap = new HashMap<>();
        String line;

        try (
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {

            // 1️⃣ Read students1.csv and store data in Map
            br1.readLine(); // skip header
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String age = data[2];

                studentInfoMap.put(id, new String[]{name, age});
            }

            // 2️⃣ Write header to merged CSV
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            // 3️⃣ Read students2.csv and merge data
            br2.readLine(); // skip header
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String marks = data[1];
                String grade = data[2];

                // Check if ID exists in first file
                if (studentInfoMap.containsKey(id)) {
                    String[] info = studentInfoMap.get(id);

                    bw.write(
                        id + "," +
                        info[0] + "," +   // Name
                        info[1] + "," +   // Age
                        marks + "," +
                        grade
                    );
                    bw.newLine();
                }
            }

            System.out.println("CSV files merged successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
