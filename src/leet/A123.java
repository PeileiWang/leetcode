package leet;

/**
 * @author: wangpeilei
 * @date: 2021/04/22 22:57
 **/
public class A123 {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 5};

        Solution solution = new Solution();
        int i = solution.maxProfit(prices);
        System.out.println(i);
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int[][][] dp = new int[prices.length][3][2];

            dp[0][0][0] = 0;
            dp[0][1][0] = Integer.MIN_VALUE;
            dp[0][1][1] = -prices[0];
            dp[0][0][1] = Integer.MIN_VALUE;


            for (int i = 1; i < prices.length; i++) {
                for (int j = 1; j <= 2; j++) {

                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);

                    if (dp[i - 1][j - 1][0] == Integer.MIN_VALUE) {
                        dp[i][j][1] = dp[i - 1][j][1];
                    } else {
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                    }
                }
            }

            return dp[prices.length - 1][2][0];
        }
    }
}
