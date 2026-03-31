import java.io.*;

public class ReadLargeFile {

    public static void main(String[] args) {

        String filePath = "source.txt";

        try (
            BufferedReader br = new BufferedReader(new FileReader(filePath))
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                // Case-insensitive check
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}
