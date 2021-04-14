package leet1_20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/04/11 11:57
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 **/
public class A6 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";

        Solution solution = new Solution();
        String convert = solution.convert(s, 3);
        System.out.println(convert);
    }

    private static class Solution {

        /**
         * 思路为每行为一个String,多行为一个list
         * @param s
         * @param numRows
         * @return
         */
        public String convert(String s, int numRows) {
            // 先算出需要几个String,即list的size
            int min = Math.min(s.length(), numRows);

            List<StringBuilder> list = new ArrayList<>();
            for (int i = 0; i < min; i++) {
                list.add(new StringBuilder());
            }

            char[] charArray = s.toCharArray();

            int length = list.size();

            /*
            按顺序往list对应的String里追加字符
            加的过程实际是list的头->尾遍历，或者尾->头遍历的过程，用j记住list操作某个元素的下标。
            每当j到达头或者到达尾的时候，用reverse表示需要正序遍历或者逆序遍历。然后遍历时根据reverse判断需要j++还是j--。
             */
            boolean reverse = true;
            int j = 0;
            for (char c : charArray) {

                if (j == 0 || j == length - 1) {
                    reverse = !reverse;
                }

                list.get(j).append(c);

                if (reverse) {
                    if (j != 0) {
                        j--;
                    }
                } else {
                    if (j != length - 1) {
                        j++;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (StringBuilder stringBuilder : list) {
                result.append(stringBuilder);
            }

            return result.toString();
        }
    }
}
