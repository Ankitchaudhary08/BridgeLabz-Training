import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {

            String line = br.readLine();   // reads ONLY the first line
            System.out.println(line);

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
