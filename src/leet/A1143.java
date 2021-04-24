package leet;

/**
 * @author: wangpeilei
 * @date: 2021/04/24 18:21
 **/
public class A1143 {
    public static void main(String[] args) {

    }

    private static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] charArray1 = text1.toCharArray();
            char[] charArray2 = text2.toCharArray();

            // 0 m n。需要加1
            // dp[i][j]表示str1长度为i时，str2长度为j时的最长公共子序列
            int[][] dp = new int[charArray1.length + 1][charArray2.length + 1];
            dp[0][0] = 0;
            dp[0][1] = 0;
            dp[1][0] = 0;
            for (int i = 1; i < charArray1.length + 1; i++) {
                for (int j = 1; j < charArray2.length + 1; j++) {

                    // 长度-1=下标
                    // 如果charArray1[i-1]== charArray2[j-1],则dp[i][j]为dp[i-1][j-1] + 1;
                    if (charArray1[i - 1] == charArray2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        continue;
                    }

                    // 否则，dp[i][j] 可能等于dp[i-1][j]、或者dp[i][j-1]。取最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

            return dp[charArray1.length][charArray2.length];
        }
    }
}
