package leet.leet41_60;

/**
 * @author: wangpeilei
 * @date: 2021/06/01 09:50
 **/
public class A45 {
    public static void main(String[] args) {


    }

    private static class Solution {
        public int jump(int[] nums) {
            int step, end, now;
            int n = nums.length - 1;
            int maxPos = 0;
            step = now = end = 0;
            while (end < n) {
                maxPos = Math.max(maxPos, nums[now] + now);
                if (now == end) {
                    step++;
                    end = maxPos;
                }
                now++;
            }
            return step;
        }
    }
}
