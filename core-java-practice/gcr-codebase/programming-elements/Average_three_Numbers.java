import java.util.Scanner; 

public class Average_three_Numbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 

        //first number
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        //second number
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        //third number
        System.out.print("Enter third number: ");
        double c = sc.nextDouble();

        // Calculate average
        double average = (a + b + c) / 3;

        // Print result
        System.out.println("Average of three numbers: " + average);
    }

    
}
