import java.io.*;

public class ImageByteArrayExample {

    public static void main(String[] args) {

        String inputImage = "input.jpg";   // original image
        String outputImage = "output.jpg"; // copied image

        try {
            // Step 1: Read image file into FileInputStream
            FileInputStream fis = new FileInputStream(inputImage);

            // Step 2: Write data into ByteArrayOutputStream
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int data;
            while ((data = fis.read()) != -1) {
                baos.write(data);
            }

            // Convert image data to byte array
            byte[] imageBytes = baos.toByteArray();

            fis.close();
            baos.close();

            // Step 3: Read from byte array using ByteArrayInputStream
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);

            // Step 4: Write bytes into new image file
            FileOutputStream fos = new FileOutputStream(outputImage);
            while ((data = bais.read()) != -1) {
                fos.write(data);
            }

            bais.close();
            fos.close();

            System.out.println("Image copied successfully!");

            // Step 5: Verify both files size
            File file1 = new File(inputImage);
            File file2 = new File(outputImage);

            if (file1.length() == file2.length()) {
                System.out.println("Verification passed: Files are identical.");
            } else {
                System.out.println("Verification failed: Files are not identical.");
            }

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}
