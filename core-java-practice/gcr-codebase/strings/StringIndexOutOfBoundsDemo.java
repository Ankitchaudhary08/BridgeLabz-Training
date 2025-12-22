import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    // Method to generate StringIndexOutOfBoundsException
    static void generateException(String text) {
        // Accessing index beyond string length
        char ch = text.charAt(text.length()); 
        System.out.println(ch);
    }

    // Method to handle StringIndexOutOfBoundsException
    static void handleException(String text) {
        try {
            char ch = text.charAt(text.length());
            System.out.println(ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception handled: StringIndexOutOfBoundsException");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Call method to generate exception
        generateException(text);

        // Call method to handle exception
        handleException(text);
    }
}
