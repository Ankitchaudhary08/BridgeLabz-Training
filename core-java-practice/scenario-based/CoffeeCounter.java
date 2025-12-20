import java.util.*;
public class CoffeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final double GST_RATE = 0.18; // 18% GST
        while (true) {
            System.out.print("\nEnter coffee type (espresso/latte/cappuccino) : ");
            String coffeeName = sc.next();

            // exit condition
            if (coffeeName.equals("exit")) {
                System.out.println("Thank you!");
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            double price = 0;

            // switch to decide coffee price
            switch (coffeeName.toLowerCase()) {
                case "espresso":
                    price = 110;
                    break;
                case "latte":
                    price = 130;
                    break;
                case "cappuccino":
                    price = 170;
                    break;
                default:
                    System.out.println("Invalid coffee Name!");
                    continue; 
            }

            double total = price * quantity;
            double gst = total * GST_RATE;
            double finalBill = total + gst;

            System.out.println("Price: " + total);
            System.out.println("GST: " + gst);
            System.out.println("Total Bill: " + finalBill);
        }

    }
}



