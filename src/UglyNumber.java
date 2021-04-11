/**
 * @author: wangpeilei
 * @date: 2021/04/10 20:10
 **/
public class UglyNumber {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isUgly(int n) {
            if (n < 1) {
                return false;
            }

            while (n % 2 == 0) {
                n /= 2;
            }

            while (n % 3 == 0) {
                n /= 3;
            }

            while (n % 5 == 0) {
                n /= 5;
            }

            return n == 1;
        }
    }
}
