import java.util.Scanner;

public class MetroSmartCard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking initial smart card balance
        System.out.print("Enter initial smart card balance: ");
        double balance = sc.nextDouble();

        // Loop will run until balance finish or user quit
        while (balance > 0) {

            // Asking user distance
            System.out.print("\nEnter distance in km (enter -1 to quit): ");
            int distance = sc.nextInt();

            // Special code to exit
            if (distance == -1) {
                System.out.println("User choose to quit.");
                break;
            }

            // Calculating fare using ternary operator
            // Small logic: <=5 km -> 10, <=15 km -> 20, else -> 30
            double fare = (distance <= 5) ? 10 :
                          (distance <= 15) ? 20 : 30;

            // Checking if balance is enough
            if (balance >= fare) {
                balance = balance - fare;
                System.out.println("Fare deducted: ₹" + fare);
                System.out.println("Remaining balance: ₹" + balance);
            } else {
                // If balance is not sufficient
                System.out.println("Insufficient balance. Please recharge.");
                break;
            }
        }

        // Final message
        System.out.println("\nThank you for using Delhi Metro Smart Card.");
        sc.close();
    }
}
