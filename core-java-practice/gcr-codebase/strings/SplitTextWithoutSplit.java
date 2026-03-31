import java.util.Scanner;

public class SplitTextWithoutSplit {

    // Find length without using length()
    static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    // Split text into words using charAt()
    static String[] customSplit(String text) {
        int len = findLength(text);

        // Count words
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        int index = 0;
        int start = 0;
        inWord = false;

        for (int i = 0; i <= len; i++) {
            if (i < len && text.charAt(i) != ' ' && !inWord) {
                start = i;
                inWord = true;
            }

            if ((i == len || text.charAt(i) == ' ') && inWord) {
                String word = "";
                for (int j = start; j < i; j++) {
                    word += text.charAt(j);
                }
                words[index++] = word;
                inWord = false;
            }
        }
        return words;
    }

    // Compare two String arrays
    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] customResult = customSplit(text);
        String[] builtInResult = text.split(" ");

        boolean result = compareArrays(customResult, builtInResult);

        System.out.println("Custom split result:");
        for (String s : customResult) {
            System.out.println(s);
        }

        System.out.println("Built-in split result:");
        for (String s : builtInResult) {
            System.out.println(s);
        }

        System.out.println("Both results are same: " + result);
    }
}
