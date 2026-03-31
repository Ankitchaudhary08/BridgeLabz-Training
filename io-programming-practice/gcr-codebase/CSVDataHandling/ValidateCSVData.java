import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSVData {

    // Email and Phone regex patterns
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\d{10}$");

    public static void main(String[] args) {

        String filePath = "users.csv";
        String line;
        int rowNumber = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // 1️⃣ Skip header
            br.readLine();

            // 2️⃣ Read each record
            while ((line = br.readLine()) != null) {
                rowNumber++;

                String[] data = line.split(",");

                String email = data[2].trim();
                String phone = data[3].trim();

                boolean valid = true;

                // 3️⃣ Validate Email
                if (!EMAIL_PATTERN.matcher(email).matches()) {
                    System.out.println("Invalid Email at row " + rowNumber + ": " + email);
                    valid = false;
                }

                // 4️⃣ Validate Phone
                if (!PHONE_PATTERN.matcher(phone).matches()) {
                    System.out.println("Invalid Phone at row " + rowNumber + ": " + phone);
                    valid = false;
                }

                // 5️⃣ Print invalid row
                if (!valid) {
                    System.out.println("Invalid Row Data: " + line);
                    System.out.println("--------------------------------");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
