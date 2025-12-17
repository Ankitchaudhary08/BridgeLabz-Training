import java.util.Scanner;

public class ClimbStairsProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //  input from user
        System.out.print("Enter number of stairs: ");
        int n = sc.nextInt();

        Solution obj = new Solution();
        int result = obj.climbStairs(n);

        //  result
        System.out.println("Number of ways: " + result);
    }
}

class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        //recursion
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
