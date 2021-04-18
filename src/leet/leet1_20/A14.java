package leet.leet1_20;

/**
 * @author: wangpeilei
 * @date: 2021/04/11 22:33
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 **/
public class A14 {
    public static void main(String[] args) {

    }

    private static class Solution {
        public String longestCommonPrefix(String[] strs) {

            if (strs.length == 0) {
                return "";
            }

            char[][] chars = new char[strs.length][];

            int minLength = Integer.MAX_VALUE;
            for (int i = 0; i < strs.length; i++) {
                chars[i] = strs[i].toCharArray();
                int length = chars[i].length;
                if (length < minLength) {
                    minLength = length;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < minLength; j++) {
                char ch = chars[0][j];

                boolean match = true;
                for (int i = 1; i < strs.length; i++) {
                    if (ch != chars[i][j]) {
                        match = false;
                    }
                }

                if (!match) {
                    break;
                }


                sb.append(ch);

            }

            return sb.toString();

        }
    }
}
