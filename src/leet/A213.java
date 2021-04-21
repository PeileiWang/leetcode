package leet;

/**
 * @author: wangpeilei
 * @date: 2021/04/21 23:46
 **/
public class A213 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 2};

        Solution solution = new Solution();
        solution.rob(nums);
    }

    private static class Solution {
        public int rob(int[] nums) {

            if (nums.length == 0) {
                return 0;
            } else if (nums.length == 1) {
                return nums[0];
            }

            return Math.max(robHelp(nums, 0, nums.length - 2),
                    robHelp(nums, 1, nums.length - 1));
        }

        private int robHelp(int[] nums, int left, int right) {
            int length = right - left;
            if (length == 0) {
                return nums[left];
            } else if (length == 1) {
                return Math.max(nums[left], nums[right]);
            }

            int[] array = new int[length + 1];
            array[0] = nums[left];
            array[1] = Math.max(nums[left], nums[left + 1]);

            for (int i = left + 2, k = 2; i <= right; i++, k++) {
                array[k] = Math.max(array[k - 1], array[k - 2] + nums[i]);
            }

            return array[array.length - 1];
        }

        private int robHelpV2(int[] nums, int left, int right) {
            int length = right - left;
            if (length == 0) {
                return nums[left];
            } else if (length == 1) {
                return Math.max(nums[left], nums[right]);
            }

            int first = nums[left];
            int second = Math.max(nums[left], nums[left + 1]);

            int temp;
            for (int i = left + 2, k = 2; i <= right; i++, k++) {
                temp = second;
                second = Math.max(second, first + nums[i]);
                first = temp;
            }

            return second;
        }
    }
}
