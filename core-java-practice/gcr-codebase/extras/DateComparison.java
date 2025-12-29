import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take first date input
        System.out.print("Enter first date (yyyy-mm-dd): ");
        LocalDate date1 = LocalDate.parse(sc.nextLine());

        // Take second date input
        System.out.print("Enter second date (yyyy-mm-dd): ");
        LocalDate date2 = LocalDate.parse(sc.nextLine());

        // Compare dates using built in methods
        if (date1.isBefore(date2)) {
            System.out.println("First date is BEFORE second date");
        }
        else if (date1.isAfter(date2)) {
            System.out.println("First date is AFTER second date");
        }
        else if (date1.isEqual(date2)) {
            System.out.println("Both dates are SAME");
        }

        // Closing scanner is good habit
        sc.close();
    }
}
