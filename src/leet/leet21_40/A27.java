package leet.leet21_40;

/**
 * @author: wangpeilei
 * @date: 2021/04/19 22:39
 **/
public class A27 {
    public static void main(String[] args) {

    }

    private static class Solution {
        public int removeElement(int[] nums, int val) {

            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    continue;
                }

                nums[j++] = nums[i];
            }

            return j;
        }
    }
}
