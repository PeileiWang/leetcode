package leet.leet61_80;

/**
 * @author: wangpeilei
 * @date: 2021/06/10 17:17
 **/
public class A69 {
    class Solution {
        public int mySqrt(int x) {
            int left = 0, right = x, ans = 0;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if ((long) mid * mid <= x) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }
    }
}
