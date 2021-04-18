package leet.leet1_20;

/**
 * @author: wangpeilei
 * @date: 2021/04/11 20:21
 *
 * 整数转罗马数字
 **/
public class A12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3999));
    }

    private static class Solution {
        public String intToRoman(int num) {
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < values.length; i++) {
                while (num >= values[i]) {
                    num -= values[i];
                    sb.append(symbols[i]);
                }
            }

            return sb.toString();
        }
    }
}
