package leet.leet21_40;

/**
 * @author: wangpeilei
 * @date: 2021/05/04 17:36
 **/
public class A31 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};

        Solution solution = new Solution();
        solution.nextPermutation(nums);

        System.out.println(1);
    }

    private static class Solution {

        /**
         * 较小数尽量靠右，较大数尽可能小
         * @param nums
         */
        public void nextPermutation(int[] nums) {
            int left = nums.length - 2;
            for (; left >= 0; left--) {
                if (nums[left] < nums[left + 1]) {
                    break;
                }
            }

            // 由于找到的数后面是降序排列，所以直接从右往左遍历，找到比找到的数大的，然后交换顺序
            if (left >= 0) {
                for (int right = nums.length - 1; right > left; right--) {
                    if (nums[right] > nums[left]) {
                        swap(nums, left, right); // 交换之后仍然为降序序
                        break;
                    }
                }
            }
            reverse(nums, left + 1); // 转成升序
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void reverse(int[] nums, int start) {
            int end = nums.length - 1;

            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
    }
}
