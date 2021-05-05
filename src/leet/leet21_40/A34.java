package leet.leet21_40;

/**
 * @author: wangpeilei
 * @date: 2021/05/05 13:26
 **/
public class A34 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,2};
        int[] ints = solution.searchRange(nums, 2);
        System.out.println(1);
    }

    private static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    int leftPos = mid, rightPos = mid;
                    for (int i = mid - 1; i >= 0; i--) {
                        if (nums[i] == target) {
                            leftPos = i;
                        } else {
                            break;
                        }
                    }

                    for (int i = mid + 1; i <= nums.length - 1; i++) {
                        if (nums[i] == target) {
                            rightPos = i;
                        } else {
                            break;
                        }
                    }

                    return new int[]{leftPos, rightPos};
                }
            }

            return new int[]{-1, -1};
        }
    }
}
