public class TextFormatter {

    public static String formatText(String paragraph) {

        // Step 1: Remove extra spaces
        paragraph = paragraph.trim().replaceAll("\\s+", " ");

        // Step 2: Ensure one space after punctuation
        paragraph = paragraph.replaceAll("\\s*([.!?])\\s*", "$1 ");

        // Step 3: Capitalize first letter of each sentence
        char[] chars = paragraph.toCharArray();
        boolean capitalizeNext = true;

        for (int i = 0; i < chars.length; i++) {
            if (capitalizeNext && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                capitalizeNext = false;
            }

            if (chars[i] == '.' || chars[i] == '?' || chars[i] == '!') {
                capitalizeNext = true;
            }
        }

        return new String(chars).trim();
    }

    // Main method to test
    public static void main(String[] args) {
        String input = "hello   world.this is  java!how are   you?  i am fine.";
        System.out.println(formatText(input));
    }
}
