import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountInFile {
    public static void main(String[] args) {

        String filePath = "sample.txt";
        String targetWord = "java";
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = br.readLine()) != null) {

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            br.close();

            System.out.println("The word '" + targetWord + "' appears " + count + " times.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
