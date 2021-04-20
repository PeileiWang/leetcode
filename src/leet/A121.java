package leet;

/**
 * @author: wangpeilei
 * @date: 2021/04/19 23:24
 **/
public class A121 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProfit(new int[]{1, 2});
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int length = prices.length;
            int[][] dp = new int[length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }

            return dp[prices.length - 1][0];
        }

        public int maxProfitV2(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            int dp_i_0 = 0;
            int dp_i_1 = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, -prices[i]);
            }

            return dp_i_0;
        }
    }
}
