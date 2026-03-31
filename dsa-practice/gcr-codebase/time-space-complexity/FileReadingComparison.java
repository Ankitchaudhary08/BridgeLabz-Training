import java.io.*;

public class FileReadingComparison {

    public static void main(String[] args) {
        String filePath = "largefile.txt"; // change path if needed

        long start, end;

        // 1️ FileReader (Character Stream)
        try {
            FileReader fr = new FileReader(filePath);
            start = System.currentTimeMillis();

            int ch;
            while ((ch = fr.read()) != -1) {
                // reading character by character
            }

            end = System.currentTimeMillis();
            System.out.println("FileReader Time: " + (end - start) + " ms");
            fr.close();

        } catch (IOException e) {
            System.out.println("FileReader Error");
        }

        // 2️ InputStreamReader (Byte to Character Stream)
        try {
            InputStreamReader isr =
                    new InputStreamReader(new FileInputStream(filePath));
            start = System.currentTimeMillis();

            int ch;
            while ((ch = isr.read()) != -1) {
                // reading using byte stream
            }

            end = System.currentTimeMillis();
            System.out.println("InputStreamReader Time: " + (end - start) + " ms");
            isr.close();

        } catch (IOException e) {
            System.out.println("InputStreamReader Error");
        }
    }
}
