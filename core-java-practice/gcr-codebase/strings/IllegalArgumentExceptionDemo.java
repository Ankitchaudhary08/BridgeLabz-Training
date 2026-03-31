import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    // Method to generate IllegalArgumentException
    static void generateException(String text) {
        // start index > end index
        String result = text.substring(5, 2);
        System.out.println(result);
    }

    // Method to handle IllegalArgumentException
    static void handleException(String text) {
        try {
            String result = text.substring(5, 2);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: Start index is greater than end index.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        // Call method to generate exception
        generateException(text);

        // Call method to handle exception
        handleException(text);
    }
}
