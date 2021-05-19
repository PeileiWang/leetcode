package leet.leet41_60;

/**
 * @author: wangpeilei
 * @date: 2021/05/19 22:45
 **/
public class A55 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 0};

        boolean b = solution.canJump(nums);
    }

    private static class Solution {
        public boolean canJump(int[] nums) {
            boolean[] booleans = new boolean[nums.length];

            booleans[nums.length - 1] = true;

            int length = nums.length;

            for (int i = nums.length - 2; i >= 0; i--) {
                int num = nums[i];

                for (int j = i + 1; j <= i + num && j <= length - 1; j++) {
                    if (booleans[j]) {
                        booleans[i] = true;
                        break;
                    }
                }
            }

            return booleans[0];
        }

        public boolean canJumpV2(int[] nums) {
            boolean[] booleans = new boolean[nums.length];

            booleans[nums.length - 1] = true;

            int length = nums.length;

            for (int i = nums.length - 2; i >= 0; i--) {
                int num = nums[i];

                int j = i + num;
                while (j >= length) {
                    j--;
                }

                for (; j > i; j--) {
                    if (booleans[j]) {
                        booleans[i] = true;
                        break;
                    }
                }
            }

            return booleans[0];
        }

        // 贪心算法，一直更新最远距离
        public boolean canJumpV3(int[] nums) {

            int rightMost = 0;
            for (int i = 0; i < nums.length; i++) {

                // 如果当前位置小于等于最远距离
                if (i <= rightMost) {
                    rightMost = Math.max(rightMost, i + nums[i]);

                    if (rightMost >= nums.length - 1) {
                        return true;
                    }
                } else { // 否则该位置已经不可达了
                    return false;
                }
            }

            return false;
        }
    }
}
