import java.util.Scanner;

public class Climb_stairs_problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stairs: ");
        int n = sc.nextInt();

        ClimbSolution obj = new ClimbSolution();
        int result = obj.climbStairs(n);

        System.out.println("Number of ways: " + result);
    }
}

class ClimbSolution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
