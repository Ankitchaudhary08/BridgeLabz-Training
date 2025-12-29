import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking date input from user (yyyy-mm-dd)
        System.out.print("Enter date (yyyy-mm-dd): ");
        String inputDate = sc.nextLine();

        LocalDate date = LocalDate.parse(inputDate);

        // Adding days, months and years step by step
        LocalDate updatedDate = date
                .plusDays(7)      // add 7 days
                .plusMonths(1)    // add 1 month
                .plusYears(2);    // add 2 years

        // Now subtract 3 weeks
        updatedDate = updatedDate.minusWeeks(3);

        // Final output
        System.out.println("Final date after calculation: " + updatedDate);

        // Program end here
        sc.close();
    }
}
