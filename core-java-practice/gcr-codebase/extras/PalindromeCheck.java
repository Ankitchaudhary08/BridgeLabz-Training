import java.util.Scanner;

public class PalindromeCheck {

    static boolean isPalindrome(String s) {
        String rev = "";
        // reverse string logic
        for (int i = s.length() - 1; i >= 0; i--) {
            rev = rev + s.charAt(i);
        }
        return s.equals(rev);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is Not Palindrome");
        }

        sc.close();
    }
}
