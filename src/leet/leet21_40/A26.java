package leet.leet21_40;

/**
 * @author: wangpeilei
 * @date: 2021/04/18 22:04
 **/
public class A26 {
    public static void main(String[] args) {

    }

    private static class Solution {
        public int removeDuplicates(int[] nums) {

            int pos = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                nums[pos++] = nums[i];
            }

            return pos;
        }
    }
}
