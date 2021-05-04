package leet.leet21_40;

/**
 * @author: wangpeilei
 * @date: 2021/05/04 22:08
 **/
public class A33 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};

        Solution solution = new Solution();
        int search = solution.search(nums, 1);
        System.out.println(search);
    }

    private static class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[left] <= nums[mid]) { // 左半边有序
                    if (nums[left] <= target && nums[mid] >= target) { // 值在之间
                        if (nums[mid] == target) {
                            return mid;
                        } else if (nums[mid] > target) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    } else { // 不在之间,查找右半边
                        left = mid + 1;
                    }
                } else { // 右半边有序
                    if (nums[right] >= target && nums[mid] <= target) { // 值在之间
                        if (nums[mid] == target) {
                            return mid;
                        } else if (nums[mid] > target) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    } else {
                        right = mid - 1;
                    }
                }
            }

            return -1;
        }
    }
}
