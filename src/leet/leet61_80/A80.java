package leet.leet61_80;

/**
 * @author: wangpeilei
 * @date: 2021/06/10 18:04
 **/
public class A80 {
    class Solution {
        public int removeDuplicates(int[] nums) {

            // 初始判断
            if (nums.length <= 2) {
                return nums.length;
            }

            int pos = 2;

            for (int i = 2; i < nums.length; i++) {
                if (nums[i] == nums[pos - 2]) {
                    continue;
                }

                nums[pos++] = nums[i];
            }

            return pos;
        }
    }
}
