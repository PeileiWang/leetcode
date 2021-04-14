package leet1_20;

/**
 * @author: wangpeilei
 * @date: 2021/04/11 21:35
 **/
public class A13 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }

    private static class Solution {
        public int romanToInt(String s) {

            int num = 0;
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length - 1; i++) {
                int cur = getInteger(chars[i]);
                int curRight = getInteger(chars[i + 1]);

                if (cur >= curRight) {
                    num += cur;
                } else {
                    num -= cur;
                }
            }

            num += getInteger(chars[chars.length - 1]);

            return num;
        }

        private int getInteger(char ch) {
            switch (ch) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
            }

            return 0;
        }
    }


}
