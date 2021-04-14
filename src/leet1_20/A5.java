package leet1_20;

/**
 * @author: wangpeilei
 * @date: 2021/04/10 22:28
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 **/
public class A5 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.longestPalindromeV2("cbbd");
        System.out.println(res);
    }

    private static class Solution {
        /**
         * 暴力求解
         *
         * @param s
         * @return
         */
        public String longestPalindromeV1(String s) {
            String resultStr = "";
            for (int i = 0; i < s.length(); i++) {
                for (int j = s.length(); j >= i; j--) {
                    String temp = s.substring(i, j);
                    if (checkPalindrome(temp) && resultStr.length() < temp.length()) {
                        resultStr = temp;
                        break;
                    }
                }
            }

            return resultStr;
        }

        private boolean checkPalindrome(String sb) {
            int length = sb.length();

            int start = 0;
            int end = length - 1;
            while (start < end) {
                if (sb.charAt(start++) != sb.charAt(end--)) {
                    return false;
                }
            }

            return true;
        }

        /**
         * 从中心点往两边扩散方式
         *
         * @param s
         * @return
         */
        public String longestPalindromeV2(String s) {

            int maxStart = 0;
            int maxLength = 0;
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                int length = palindrome(charArray, i, i);
                int length2 = palindrome(charArray, i, i + 1);

                int curMax = Math.max(length, length2);

                if (curMax > maxLength) {
                    maxLength = curMax;

                    // 发现规律
                    maxStart = i - (curMax - 1) / 2;
                }
            }

            return s.substring(maxStart, maxStart + maxLength);
        }

        private int palindrome(char[] s, int i, int j) {
            if (i == s.length - 1) {
                return 1;
            }

            while (i >= 0 && j < s.length) {
                if (s[i] == s[j]) {
                    i--;
                    j++;
                } else {
                    break;
                }
            }

            return j - i - 1;
        }

        /**
         * 动态规划
         * 更大的结果依赖于更小的结果，将更小的结果存到一个地方。空间换时间
         * @param s
         * @return
         */
        public String longestPalindromeV3(String s) {
            int length = s.length();
            boolean[][] res = new boolean[length][length];

            char[] charArray = s.toCharArray();

            int maxLength = 0;
            int startIndex = 0;

            for (int j = 0; j < length; j++) {
                for (int i = 0; i <= j; i++) {
                    if (i == j) {
                        res[i][j] = true;
                    } else {
                        if (charArray[i] == charArray[j]) {
                            if (j - i < 3) {
                                res[i][j] = true;
                            } else {
                                res[i][j] = res[i + 1][j - 1];
                            }
                        } else {
                            res[i][j] = false;
                        }
                    }

                    if (res[i][j]) {
                        if (maxLength < (j - i + 1)) {
                            maxLength = j - i + 1;
                            startIndex = i;
                        }
                    }
                }
            }

            return s.substring(startIndex, startIndex + maxLength);

        }
    }
}
