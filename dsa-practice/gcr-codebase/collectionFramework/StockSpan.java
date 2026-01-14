import java.util.Stack;

class StockSpan {

    static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Pop while current price is higher
            while (!st.isEmpty() && prices[st.peek()] <= prices[i]) {
                st.pop();
            }

            // Calculate span
            span[i] = st.isEmpty() ? (i + 1) : (i - st.peek());

            // Push current index
            st.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] result = calculateSpan(prices);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
