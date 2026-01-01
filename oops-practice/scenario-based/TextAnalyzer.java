public class TextAnalyzer {

    public static void analyzeText(String paragraph, String oldWord, String newWord) {

        // Handle empty or space-only string
        if (paragraph == null || paragraph.trim().isEmpty()) {
            System.out.println("Paragraph is empty or contains only spaces.");
            return;
        }

        // Trim extra spaces
        paragraph = paragraph.trim();

        // Split words
        String[] words = paragraph.split("\\s+");

        // Count words
        int wordCount = words.length;
        System.out.println("Total Words: " + wordCount);

        // Find longest word
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Longest Word: " + longestWord);

        // Replace word (case-insensitive)
        String replacedText =
                paragraph.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);

        System.out.println("Updated Paragraph:");
        System.out.println(replacedText);
    }

    // Main method
    public static void main(String[] args) {

        String paragraph = "Java is powerful and Java is easy to learn";
        analyzeText(paragraph, "java", "Python");
    }
}
