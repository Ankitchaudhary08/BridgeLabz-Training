import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSV {

    public static void main(String[] args) {

        String filePath = "large.csv";
        int batchSize = 100;
        int count = 0;
        int totalProcessed = 0;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                count++;
                totalProcessed++;

                // process line here
                // System.out.println(line);

                if (count == batchSize) {
                    System.out.println("Processed records: " + totalProcessed);
                    count = 0; // reset batch
                }
            }

            System.out.println("Total records processed: " + totalProcessed);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
