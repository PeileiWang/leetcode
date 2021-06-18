package leet.leet41_60;

/**
 * @author: wangpeilei
 * @date: 2021/06/18 15:34
 **/
public class A42 {
    class Solution {
        public int trap(int[] height) {
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];

            for (int i = 1; i < height.length; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            }

            for (int i = height.length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
            }

            int total = 0;

            for (int i = 1; i < height.length - 1; i++) {
                int sub = Math.min(leftMax[i], rightMax[i]) - height[i];
                if (sub > 0) {
                    total += sub;
                }
            }
            return total;
        }
    }
}
