package leet1_20;

import java.util.Arrays;

/**
 * @author: wangpeilei
 * @date: 2021/04/12 22:41
 **/
public class A16 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        int result = solution.threeSumClosest(nums, target);

        System.out.println(result);
    }

    private static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);

            int min = Integer.MAX_VALUE;
            int closeSum = 0;
            for (int i = 0; i < nums.length - 2; i++) {

                /*
                如果当前跟之前的一个数一样，由于之前的这个数已经计算过最接近的，这个数不需要再计算
                 */
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    int res;
                    if (sum > target) {
                        res = sum - target;
                        right--;
                    } else if (sum < target) {
                        res = target - sum;
                        left++;
                    } else {
                        return target;
                    }

                    if (res < min) {
                        min = res;
                        closeSum = sum;
                    }
                }
            }

            return closeSum;
        }
    }
}
