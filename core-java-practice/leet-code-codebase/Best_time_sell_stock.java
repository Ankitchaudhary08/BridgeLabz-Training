import java.util.Scanner;

public class Best_time_sell_stock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // array size
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        // price of stock on each day

        
        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        int profit = obj.maxProfit(prices);

        // Output
        System.out.println("Maximum Profit: " + profit);
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            max = Math.max((prices[i] - min), max);
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return max;
    }
}
