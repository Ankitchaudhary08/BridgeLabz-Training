import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Iterative comparison using charAt()
    static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive comparison
    static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Reverse string using charAt()
    static char[] reverseString(String text) {
        int len = text.length();
        char[] reverse = new char[len];
        for (int i = 0; i < len; i++) {
            reverse[i] = text.charAt(len - 1 - i);
        }
        return reverse;
    }

    // Logic 3: Using character arrays
    static boolean isPalindromeUsingArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        boolean result1 = isPalindromeIterative(text);
        boolean result2 = isPalindromeRecursive(text, 0, text.length() - 1);
        boolean result3 = isPalindromeUsingArray(text);

        System.out.println("Palindrome check (Iterative): " + result1);
        System.out.println("Palindrome check (Recursive): " + result2);
        System.out.println("Palindrome check (Using Array): " + result3);
    }
}
