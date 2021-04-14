package leet1_20;

/**
 * @author: wangpeilei
 * @date: 2021/04/11 12:44
 *
 * 数字reverse
 **/
public class A7 {
    public static void main(String[] args) {
        int x = -123;

        Solution solution = new Solution();
        int reverse = solution.reverse(x);
        System.out.println(reverse);
    }

    private static class Solution {
        public int reverse(int x) {

            int res = 0;

            while (x != 0) {
                int cur = x % 10;
                x /= 10;

                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && cur > 7)) {
                    return 0;
                } else if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && cur < -8)) {
                    return 0;
                }

                res = res * 10 + cur;
            }

            return res;
        }
    }
}
