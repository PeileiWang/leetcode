package leet;

/**
 * @author: wangpeilei
 * @date: 2021/04/20 22:34
 **/
public class A122 {
    public static void main(String[] args) {

    }

    private static class Solution {

        /**
         * 动态规划
         *
         * @param prices
         * @return
         */
        public int maxProfitV2(int[] prices) {
            int[][] dp = new int[prices.length][2];

            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }

            return dp[prices.length - 1][0];
        }

        /**
         * 动态规划简化
         *
         * @param prices
         * @return
         */
        public int maxProfitV3(int[] prices) {
            int dp_i_0 = 0;
            int dp_i_1 = -prices[0];

            int temp;
            for (int i = 1; i < prices.length; i++) {
                temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }

            return dp_i_0;
        }
    }
}
