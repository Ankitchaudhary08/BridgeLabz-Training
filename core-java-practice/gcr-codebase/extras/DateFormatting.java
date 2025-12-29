import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {

    public static void main(String[] args) {

        // Get current system date
        LocalDate today = LocalDate.now();

        // Different date formats
        DateTimeFormatter format1 =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter format2 =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeFormatter format3 =
                DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Print date in different formats
        System.out.println("Format 1 : " + today.format(format1));
        System.out.println("Format 2 : " + today.format(format2));
        System.out.println("Format 3 : " + today.format(format3));

        // Simple program only for formatting date
    }
}
