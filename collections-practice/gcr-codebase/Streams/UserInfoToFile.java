import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInfoToFile {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = null;

        try {
            // Take input from user
            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            String age = br.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            // Write data to file
            fw = new FileWriter("user_info.txt");

            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + language + "\n");

            System.out.println("\nData saved successfully into file.");

        } catch (IOException e) {
            System.out.println("An error occurred while reading input or writing file.");
            System.out.println(e.getMessage());

        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                System.out.println("Error while closing file.");
            }
        }
    }
}
