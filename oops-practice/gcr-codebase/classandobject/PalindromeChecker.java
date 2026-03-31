class PalindromeChecker {

    String text;

    // this method check string is palindrome or not
    boolean isPalindrome() {

        // remove space and convert to lowercase
        String cleanedText = text.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = cleanedText.length() - 1;

        while (start < end) {
            if (cleanedText.charAt(start) != cleanedText.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // this method display result
    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }

    public static void main(String[] args) {

        // first text
        PalindromeChecker p1 = new PalindromeChecker();
        p1.text = "A man a plan a canal Panama";
        p1.displayResult();

        // second text
        PalindromeChecker p2 = new PalindromeChecker();
        p2.text = "Hello";
        p2.displayResult();
    }
}
