import java.util.*;

class StringComparison {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Read first string
        System.out.print("Input first string: ");
        String first = input.next();

        // Read second string
        System.out.print("Input second string: ");
        String second = input.next();

        // Custom comparison
        boolean manualResult = compareManually(first, second);

        // Built-in comparison
        boolean equalsResult = first.equals(second);

        // Display results
        System.out.println("Manual comparison result: " + (manualResult ? "Equal" : "Not Equal"));
        System.out.println("equals() method result: " + (equalsResult ? "Equal" : "Not Equal"));

        // Final verification
        if (manualResult == equalsResult) {
            System.out.println("Both comparison methods match.");
        } else {
            System.out.println("Comparison methods do not match.");
        }

        
    }

    // Custom string comparison using charAt
    static boolean compareManually(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        for (int index = 0; index < a.length(); index++) {
            if (a.charAt(index) != b.charAt(index)) {
                return false;
            }
        }
        return true;
    }
}
