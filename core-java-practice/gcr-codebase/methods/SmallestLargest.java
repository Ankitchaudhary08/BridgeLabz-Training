import java.util.Scanner;

public class SmallestLargest {

    // this method find smallest and largest number
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {

        int smallest = number1;
        int largest = number1;

        // checking second number
        if (number2 < smallest) {
            smallest = number2;
        }
        if (number2 > largest) {
            largest = number2;
        }

        // checking third number
        if (number3 < smallest) {
            smallest = number3;
        }
        if (number3 > largest) {
            largest = number3;
        }

        // storing result in array
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking three numbers from user
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.print("Enter third number: ");
        int c = sc.nextInt();

        // calling method
        int[] result = findSmallestAndLargest(a, b, c);

        // printing output
        System.out.println("Smallest number is " + result[0]);
        System.out.println("Largest number is " + result[1]);

        sc.close();
    }
}
