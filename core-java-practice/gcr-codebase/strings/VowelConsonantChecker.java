import java.util.Scanner;

public class VowelConsonantChecker {

    // Method to check character type
    public static String checkCharType(char ch) {
        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method to analyze string and return 2D array
    public static String[][] analyzeString(String text) {
        int count = text.length();
        String[][] result = new String[count][2];

        for (int i = 0; i < count; i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharType(ch);
        }
        return result;
    }

    // Method to display result in tabular format
    public static void displayResult(String[][] data) {
        System.out.println("Character\tType");
        System.out.println("----------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] analysis = analyzeString(input);
        displayResult(analysis);
    }
}
