/**
 * @author: wangpeilei
 * @date: 2021/04/11 18:16
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class A11 {

    public static void main(String[] args) {

    }

    public static class Solution {

        /**
         * 暴力求解
         *
         * @param height
         * @return
         */
        public int maxArea(int[] height) {
            int length = height.length;

            int max = 0;
            for (int i = 0; i < length - 1; i++) {
                for (int j = i + 1; j < length; j++) {
                    int curMax = Math.min(height[i], height[j]) * (j - i);
                    if (curMax > max) {
                        max = curMax;
                    }
                }
            }

            return max;
        }


        /**
         * 双指针
         *
         * @param height
         * @return
         */
        public int maxAreaV2(int[] height) {
            int i = 0;
            int j = height.length - 1;

            int max = 0;
            while (i < j) {
                int curMax = Math.min(height[i], height[j]) * (j - i);
                if (max < curMax) {
                    max = curMax;
                }

                if (height[i] > height[j]) {
                    j--;
                } else {
                    i++;
                }
            }

            return max;
        }
    }
}
