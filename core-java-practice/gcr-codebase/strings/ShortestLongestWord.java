import java.util.Scanner;

public class ShortestLongestWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take complete text input
        String text = sc.nextLine();

        // Split text into words (without split())
        String[] words = splitWords(text);

        // Create 2D array of words and their lengths
        String[][] wordLengthTable = createWordLengthTable(words);

        // Find shortest and longest word indexes
        int[] result = findShortestAndLongest(wordLengthTable);

        // Display result
        System.out.println("Shortest word: " + wordLengthTable[result[0]][0]);
        System.out.println("Longest word: " + wordLengthTable[result[1]][0]);
    }

    // Split text into words using charAt()
    public static String[] splitWords(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }

        String[] words = new String[count + 1];
        int start = 0, index = 0;

        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || text.charAt(i) == ' ') {
                words[index++] = text.substring(start, i);
                start = i + 1;
            }
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

    // Create 2D array of word and length
    public static String[][] createWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            int len = findLength(words[i]);
            table[i][0] = words[i];
            table[i][1] = String.valueOf(len);
        }
        return table;
    }

    // Find shortest and longest word
    public static int[] findShortestAndLongest(String[][] table) {
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < table.length; i++) {
            int currentLen = Integer.parseInt(table[i][1]);
            int minLen = Integer.parseInt(table[minIndex][1]);
            int maxLen = Integer.parseInt(table[maxIndex][1]);

            if (currentLen < minLen) {
                minIndex = i;
            }
            if (currentLen > maxLen) {
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }
}
