package leet1_20;

import java.util.Stack;

/**
 * @author: wangpeilei
 * @date: 2021/04/14 23:56
 **/
public class A20 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "{[]}";
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }

    private static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();

            for (char aChar : chars) {

                // 是左括号，入栈
                if (isLeft(aChar)) {
                    stack.push(aChar);
                } else { // 是右括号

                    // 如果栈是空，即入栈底的是右括号，则一定不是有效的
                    if (stack.isEmpty()) {
                        return false;
                    }

                    Character popChar = stack.pop();
                    if (!isLeftMatchRight(popChar, aChar)) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }

        private boolean isLeftMatchRight(char popChar, char aChar) {
            return (aChar == ')' && popChar == '(') ||
                    (aChar == ']' && popChar == '[') ||
                    (aChar == '}' && popChar == '{');
        }

        private boolean isLeft(char aChar) {
            return '(' == aChar || '[' == aChar || '{' == aChar;
        }
    }
}
