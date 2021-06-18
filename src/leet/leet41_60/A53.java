package leet.leet41_60;

/**
 * @author: wangpeilei
 * @date: 2021/05/13 22:37
 **/
public class A53 {
    private static class Solution {

        // 暴力
        public int maxSubArray(int[] nums) {
            int max = nums[0];

            int cur = max;
            for (int i = 1; i < nums.length; i++) {
                cur += nums[i];
                max = Math.max(cur, max);

                int temp = cur;
                for (int j = 0; j < i; j++) {
                    temp -= nums[j];
                    max = Math.max(temp, max);
                }
            }

            return max;
        }

        // 规律
        public int maxSubArray2(int[] nums) {
            int max = nums[0];

            int sum = 0;
            for (int num : nums) {
                if (sum > 0) {
                    sum += num;
                } else { // 如果算的和已经是小于等于0。那没必要再用sum。直接用当前的num
                    sum = num;
                }

                max = Math.max(max,sum);
            }

            return max;
        }

    }
}
