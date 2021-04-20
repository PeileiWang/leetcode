package algorithm.dp;

/**
 * @author: wangpeilei
 * @date: 2021/04/20 23:12
 **/
public class CutSteel {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int i = get(nums);
        System.out.println(i);
    }

    private static int get(int[] nums) {
        int[] dp = new int[nums.length + 1]; // 因为从[0,n]，共n+1

        for (int i = 1; i < nums.length + 1; i++) {
            int curMax = nums[i - 1]; // 不切割，

            /* 从1+剩余、2+剩余...找出最大的。动态规划的思路是只找最优解。
            比如5可分成2的最优解加3的最优解。为何不分解成1+1+3的最优解，是因为2的最优解已经考虑过1+1的解以及0+2的解，取得了最优的。
            */
            for (int j = 1; j <= i / 2; j++) {
                curMax = Math.max(curMax, dp[j] + dp[i - j]);
            }
            dp[i] = curMax;
        }

        return dp[nums.length];
    }
}
