import java.util.Scanner; // Import Scanner for input

public class ProfitAndLoss {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Create Scanner object

        // Cost price
        System.out.print("Enter Cost Price: ");
        double costPrice = sc.nextDouble();

        // selling price 
        System.out.print("Enter Selling Price: ");
        double sellingPrice = sc.nextDouble();

        //  profit
        double profit = sellingPrice - costPrice;

        //profit percentage
        double profitPercentage = (profit / costPrice) * 100;

        
        System.out.println(
            "The Cost Price is  " + costPrice + " and Selling Price is" + sellingPrice + "\n" +
            "The Profit is " + profit + " and the Profit Percentage is " + profitPercentage
        );
    }
}
