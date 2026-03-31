import java.util.Scanner;

public class LeapYearChecker {

    // this method check leap year or not
    public static boolean isLeapYear(int year) {

        // leap year condition check
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking year from user
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if (year < 1582) {
            System.out.println("Year must be 1582 or later");
        } else {
            if (isLeapYear(year)) {
                System.out.println("Year is a Leap Year");
            } else {
                System.out.println("Year is not a Leap Year");
            }
        }

        sc.close();
    }
}
