import java.util.*;

public class KeyGeneration {

    static boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;
        if (s.length() < 6) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)) return false;
        }
        return true;
    }

    static String getInvalidReason(String s) {
        if (s == null || s.isEmpty()) return "Invalid Input (empty string)";
        if (s.contains(" ")) return "Invalid Input (contains space)";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) return "Invalid Input (contains digits)";
        }
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return "Invalid Input (contains special character)";
        }
        if (s.length() < 6) return "Invalid Input (length < 6)";
        return null;
    }

    static String generateKey(String s) {
        // Step 1: Convert to lowercase
        String lower = s.toLowerCase();

        // Step 2: Remove characters with even ASCII values
        StringBuilder sb = new StringBuilder();
        for (char c : lower.toCharArray()) {
            if ((int) c % 2 != 0) sb.append(c);
        }

        // Step 3: Reverse
        String reversed = sb.reverse().toString();

        // Step 4: Convert chars at even index (0-based) to uppercase
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            if (i % 2 == 0) result.append(Character.toUpperCase(reversed.charAt(i)));
            else result.append(reversed.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            // Check for empty line
            String s = line.trim();

            String reason = getInvalidReason(s.isEmpty() ? "" : line);
            if (reason != null) {
                // Special: check for empty string (line is blank)
                if (line.trim().isEmpty()) {
                    System.out.println("Invalid Input (empty string)");
                } else {
                    System.out.println(reason);
                }
            } else {
                System.out.println("The generated key is - " + generateKey(s));
            }
        }
        sc.close();
    }
}
