import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    public static void main(String[] args) {

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Open source file
            fis = new FileInputStream("source.txt");

            // Open destination file (auto-created if not exists)
            fos = new FileOutputStream("destination.txt");

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("Source file does not exist or an IO error occurred.");
        } finally {
            try {
                if (fis != null)
                    fis.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                System.out.println("Error while closing files.");
            }
        }
    }
}
