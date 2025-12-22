import java.util.Scanner;

public class SubstringComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take string input
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Take start and end index
        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        // Create substring using charAt()
        String customSub = createSubstringUsingCharAt(text, start, end);

        // Create substring using built-in method
        String builtInSub = text.substring(start, end);

        // Compare both substrings
        boolean isSame = compareStringsUsingCharAt(customSub, builtInSub);

        // Display results
        System.out.println("Substring using charAt(): " + customSub);
        System.out.println("Substring using substring(): " + builtInSub);
        System.out.println("Are both substrings equal? " + isSame);
    }

    // Method to create substring using charAt()
    public static String createSubstringUsingCharAt(String str, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStringsUsingCharAt(String s1, String s2) {
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
