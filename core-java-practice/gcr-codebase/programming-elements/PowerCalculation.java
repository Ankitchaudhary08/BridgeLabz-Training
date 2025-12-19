import java.util.Scanner; 

public class PowerCalculation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 

        //  base input
        System.out.print("Enter base number: ");
        double base = sc.nextDouble();

        // exponent 
        System.out.print("Enter exponent: ");
        double exponent = sc.nextDouble();

    
        double result = Math.pow(base, exponent);

        // output
        System.out.println("Result: " + result);
    }
}
