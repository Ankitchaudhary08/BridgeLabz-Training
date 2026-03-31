import java.util.Scanner;

public class TrimSpacesDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text with spaces: ");
        String text = sc.nextLine();

        // Get start and end index after trimming spaces
        int[] range = findTrimRange(text);

        // Create trimmed string using charAt()
        String customTrimmed = createSubstring(text, range[0], range[1]);

        // Built-in trim
        String builtInTrimmed = text.trim();

        // Compare both results
        boolean same = compareStrings(customTrimmed, builtInTrimmed);

        System.out.println("Custom Trim Result: [" + customTrimmed + "]");
        System.out.println("Built-in Trim Result: [" + builtInTrimmed + "]");
        System.out.println("Both results are same: " + same);
    }

    // Method to find start and end index without leading/trailing spaces
    public static int[] findTrimRange(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end && s.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && s.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end + 1};
    }

    // Method to create substring using charAt()
    public static String createSubstring(String s, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += s.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
