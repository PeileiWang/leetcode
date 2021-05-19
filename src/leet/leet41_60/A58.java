package leet.leet41_60;

/**
 * @author: wangpeilei
 * @date: 2021/05/19 21:44
 **/
public class A58 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int a_ = solution.lengthOfLastWord("a ");
    }

    private static class Solution {
        public int lengthOfLastWord(String s) {
            char[] chars = s.toCharArray();

            int i = chars.length - 1;

            while (i >= 0 && chars[i] == ' ') {
                i--;
            }

            if (i == -1) {
                return 0;
            }

            int j = i;
            for (; j >= 0; j--) {
                if (chars[j] == ' ') {
                    break;
                }
            }

            return i - j;
        }
    }
}
