package leet;

/**
 * @author: wangpeilei
 * @date: 2021/04/21 23:21
 **/
public class A198 {
    public static void main(String[] args) {

    }

    private static class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            int[] dp = new int[length];

            if (nums.length == 0) {
                return 0;
            } else if (nums.length == 1) {
                return nums[0];
            } else if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            dp[length - 1] = nums[length - 1];
            dp[length - 2] = Math.max(nums[length - 1], nums[length - 2]);
            for (int i = length - 3; i >= 0; i--) {
                dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
            }

            return dp[0];
        }

        public int rob2(int[] nums) {
            int length = nums.length;

            if (nums.length == 0) {
                return 0;
            } else if (nums.length == 1) {
                return nums[0];
            } else if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            int first = nums[0];
            int second = Math.max(nums[0], nums[1]);
            int temp;
            for (int i = 2; i < length; i++) {
                // 昨天偷过，今天不偷。或者前天偷，今天偷

                temp = second;
                second = Math.max(second, first + nums[i]);
                first = temp;
            }

            return second;
        }
    }
}
