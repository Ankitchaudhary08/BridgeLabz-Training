import java.util.Scanner;

public class NumberFormatExceptionDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a value: ");
        String text = sc.next();

        // 1. Call method that generates the exception
        generateException(text);

        // 2. Call method that handles the exception
        handleException(text);
    }

    // Method to generate NumberFormatException
    public static void generateException(String text) {
        int number = Integer.parseInt(text); // may throw NumberFormatException
        System.out.println("Converted number: " + number);
    }

    // Method to handle NumberFormatException
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: Invalid number format");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught");
        }
    }
}
