import java.util.Scanner;

public class UppercaseComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take complete text input
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        // Convert using custom method
        String customUpper = convertToUpper(text);

        // Convert using built-in method
        String builtInUpper = text.toUpperCase();

        // Compare results
        boolean isSame = compareStrings(customUpper, builtInUpper);

        System.out.println("Custom Uppercase   : " + customUpper);
        System.out.println("Built-in Uppercase : " + builtInUpper);
        System.out.println("Are both same?     : " + isSame);
    }

    // Method to convert string to uppercase using charAt()
    public static String convertToUpper(String input) {
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            result += ch;
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
