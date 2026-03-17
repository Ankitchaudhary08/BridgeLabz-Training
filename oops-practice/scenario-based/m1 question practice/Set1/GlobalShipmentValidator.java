import java.util.*;

public class GlobalShipmentValidator {

    static boolean isValidShipmentCode(String code) {
        // Must be SHIP-XXXXXX: 6 digits, first != 0, no digit repeats > 3 consecutively
        if (!code.matches("SHIP-\\d{6}")) return false;
        String digits = code.substring(5);
        if (digits.charAt(0) == '0') return false;
        // Check no digit repeats more than 3 times consecutively
        if (digits.matches(".*(.)\\1{3,}.*")) return false;
        return true;
    }

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    static boolean isValidDate(String date) {
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) return false;
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        if (year < 2000 || year > 2099) return false;
        if (month < 1 || month > 12) return false;

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) daysInMonth[1] = 29;

        return day >= 1 && day <= daysInMonth[month - 1];
    }

    static boolean isValidMode(String mode) {
        return mode.equals("AIR") || mode.equals("SEA") || mode.equals("ROAD")
                || mode.equals("RAIL") || mode.equals("EXPRESS") || mode.equals("FREIGHT");
    }

    static boolean isValidWeight(String weight) {
        // Positive, up to 2 decimal places, no leading zeros unless exactly 0, max 999999.99
        if (!weight.matches("(0|[1-9]\\d*)(\\.\\d{1,2})?")) return false;
        double val = Double.parseDouble(weight);
        return val > 0 && val <= 999999.99;
    }

    static boolean isValidStatus(String status) {
        return status.equals("DELIVERED") || status.equals("CANCELLED") || status.equals("IN_TRANSIT");
    }

    static String validate(String record) {
        String[] parts = record.split("\\|");
        if (parts.length != 5) return "NON-COMPLIANT RECORD";

        if (!isValidShipmentCode(parts[0])) return "NON-COMPLIANT RECORD";
        if (!isValidDate(parts[1])) return "NON-COMPLIANT RECORD";
        if (!isValidMode(parts[2])) return "NON-COMPLIANT RECORD";
        if (!isValidWeight(parts[3])) return "NON-COMPLIANT RECORD";
        if (!isValidStatus(parts[4])) return "NON-COMPLIANT RECORD";

        return "COMPLIANT RECORD";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String record = sc.nextLine().trim();
            System.out.println(validate(record));
        }
        sc.close();
    }
}
