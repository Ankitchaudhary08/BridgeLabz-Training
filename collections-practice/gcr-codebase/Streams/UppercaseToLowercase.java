import java.io.*;

public class UppercaseToLowercase {

    public static void main(String[] args) {

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Try-with-resources (auto close)
        try (
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw)
        ) {
            String line;

            // Read line by line
            while ((line = br.readLine()) != null) {
                // Convert to lowercase
                bw.write(line.toLowerCase());
                bw.newLine(); // keep line breaks
            }

            System.out.println("File converted from UPPERCASE to lowercase successfully.");

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}
