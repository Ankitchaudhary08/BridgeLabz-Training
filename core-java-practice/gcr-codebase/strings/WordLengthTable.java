import java.util.Scanner;

public class WordLengthTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] table = createWordLengthTable(words);

        System.out.println("\nWord\tLength");
        System.out.println("--------------");
        for (int i = 0; i < table.length; i++) {
            int len = Integer.parseInt(table[i][1]);
            System.out.println(table[i][0] + "\t" + len);
        }
    }

    // Split text into words using charAt()
    public static String[] splitWords(String text) {
        int wordCount = 0;
        boolean inWord = false;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        int index = 0;
        String temp = "";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                temp += text.charAt(i);
            } else if (!temp.equals("")) {
                words[index++] = temp;
                temp = "";
            }
        }

        if (!temp.equals("")) {
            words[index] = temp;
        }

        return words;
    }

    // Find length without using length()
    public static int findLength(String word) {
        int count = 0;
        try {
            while (true) {
                word.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    // Create 2D array of word and its length
    public static String[][] createWordLengthTable(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }
}
