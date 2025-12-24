import java.util.Scanner;

public class ChocolateDistribution {

    // this method find how many choclate each child get and remaining
    public static int[] findRemainderAndQuotient(int number, int divisor) {

        int eachChild = number / divisor;
        int remaining = number % divisor;

        return new int[]{eachChild, remaining};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking total chocolates
        System.out.print("Enter number of chocolates: ");
        int chocolates = sc.nextInt();

        // taking number of children
        System.out.print("Enter number of children: ");
        int children = sc.nextInt();

        // calling method
        int[] result = findRemainderAndQuotient(chocolates, children);

        // printing output
        System.out.println("Each child gets " + result[0] + " chocolates");
        System.out.println("Remaining chocolates are " + result[1]);

        sc.close();
    }
}
