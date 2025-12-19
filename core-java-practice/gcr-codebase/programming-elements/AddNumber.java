import java.util.Scanner;

public class AddNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         //take a input of first number
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
 
        //take inout of second number
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        int sum = a + b;
        //sum of two number
        System.out.println(sum);
    }
}
