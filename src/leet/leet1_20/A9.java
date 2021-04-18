package leet.leet1_20;

/**
 * @author: wangpeilei
 * @date: 2021/04/11 13:17
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 **/
public class A9 {

    /**
     * 可用char,或者用数字判断
     */
    private static class Solution {
        public boolean isPalindrome(int x) {

            if (x < 0) {
                return false;
            } else if (x == 0) {
                return true;
            } else if (x % 10 == 0) {
                return false;
            }

            int y = x;
            int res = 0;

            while (y != 0) {
                int cur = y % 10;
                y /= 10;

                res = res * 10 + cur;
            }

            return res == x;
        }

        public boolean isPalindromeV1(int x) {
            if (x < 0) {
                return false;
            } else if (x == 0) {
                return true;
            } else if ((x % 10 == 0)) {
                return false;
            }

            char[] chars = String.valueOf(x).toCharArray();

            int i = 0;
            int j = chars.length - 1;

            while (i <= j) {
                if (chars[i++] != chars[j--]) {
                    return false;
                }
            }

            return true;
        }
    }

}
