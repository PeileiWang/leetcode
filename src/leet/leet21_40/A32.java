package leet.leet21_40;

import java.util.Stack;

/**
 * @author: wangpeilei
 * @date: 2021/05/04 21:29
 **/
public class A32 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.longestValidParentheses("(()");

        System.out.println(i);
    }

    private static class Solution {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            char[] chars = s.toCharArray();

            boolean[] booleans = new boolean[chars.length];

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < chars.length; i++) {
                if ('(' == chars[i]) {
                    stack.push(i);
                } else { // ')' == chars[i]
                    if (stack.isEmpty()) {
                        booleans[i] = true;
                    } else {
                        stack.pop();
                    }
                }
            }

            while (!stack.isEmpty()) {
                booleans[stack.pop()] = true;
            }

            int maxLength = 0;
            int length = 0;
            for (boolean bool : booleans) {
                if (bool) {
                    length = 0;
                } else {
                    length++;
                }
                maxLength = Math.max(length, maxLength);
            }

            return maxLength;
        }
    }
}
