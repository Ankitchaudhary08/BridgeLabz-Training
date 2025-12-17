import java.util.Scanner;

public class ReverseIntegerProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking Input
        System.out.print("Enter an integer: ");
        int x = sc.nextInt();

        Solution obj = new Solution();
        int result = obj.reverse(x);

        // Show the result
        System.out.println("Reversed number: " + result);
    }
}

class Solution {
    public int reverse(int x) {
        int rem = 0;
        int value = 0;

        while (x != 0) {
            rem = x % 10;

            // check the overflow
            if (value > Integer.MAX_VALUE / 10 || value < Integer.MIN_VALUE / 10) {
                return 0;
            }

            value = value * 10 + rem;
            x = x / 10;
        }
        return value;
    }
}
