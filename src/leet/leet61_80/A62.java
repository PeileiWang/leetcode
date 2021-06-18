package leet.leet61_80;

/**
 * @author: wangpeilei
 * @date: 2021/05/31 15:36
 **/
public class A62 {
    class Solution {
        public int uniquePaths(int m, int n) {
            int a = Math.min(m - 1, n - 1);

            int b = m + n - 2;

            long total = 1;
            for (int i = 0; i < a; i++) {
                total *= (b-i);
            }

            for (int i = 1; i <= a; i++) {
                total /= i;
            }
            return (int) total;
        }
    }
}
