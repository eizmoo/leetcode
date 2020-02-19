package new_start_in_2020.less_than_100;

/**
 * MaxProfit2_122
 *
 * @author liuwei06
 * @date 2020/02/18
 */
public class MaxProfit2_122 {

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * 买股票的最佳时期 II
     * in  :[1,2,3,4,5]
     * out :4
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }

}
