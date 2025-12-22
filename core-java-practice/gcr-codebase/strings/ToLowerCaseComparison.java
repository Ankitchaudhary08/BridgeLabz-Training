import java.util.Scanner;

public class ToLowerCaseComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take complete text input
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        // Convert using user-defined method
        String customLower = convertToLower(text);

        // Convert using built-in method
        String builtInLower = text.toLowerCase();

        // Compare results
        boolean isSame = compareStrings(customLower, builtInLower);

        System.out.println("Lowercase using charAt(): " + customLower);
        System.out.println("Lowercase using toLowerCase(): " + builtInLower);
        System.out.println("Both results are same: " + isSame);
    }

    // Method to convert text to lowercase using charAt()
    public static String convertToLower(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result = result + ch;
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
