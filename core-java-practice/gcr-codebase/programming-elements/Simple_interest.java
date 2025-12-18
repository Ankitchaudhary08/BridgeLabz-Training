import java.util.Scanner; 

public class Simple_interest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // principal amount
        System.out.print("Enter principal amount: ");
        double principal = sc.nextDouble();

        //  rate of interest
        System.out.print("Enter rate of interest: ");
        double rate = sc.nextDouble();

        // time period
        System.out.print("Enter time (in years): ");
        double time = sc.nextDouble();

        
        // SI = (P × R × T) / 100
        double simpleInterest = (principal * rate * time) / 100;

        // result
        System.out.println("Simple Interest: " + simpleInterest);
    }
}
