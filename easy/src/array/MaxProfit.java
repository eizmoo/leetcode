package array;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length > 1) {
            return 0;
        }
        int profits = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profits += prices[i] - prices[i - 1];
            }
        }
        return profits;
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfit().maxProfit(a));
    }
}
