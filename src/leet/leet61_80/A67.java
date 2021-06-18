package leet.leet61_80;

/**
 * @author: wangpeilei
 * @date: 2021/06/10 17:07
 **/
public class A67 {
    class Solution {
        public String addBinary(String a, String b) {


            StringBuilder builder = new StringBuilder();

            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();

            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;
            while (i >= 0 || j >= 0) {
                int aValue = i >= 0 ? aChars[i] - '0' : 0;
                int bValue = j >= 0 ? bChars[j] - '0' : 0;

                int sum = (aValue + bValue + carry) % 2;
                carry = (aValue + bValue + carry) / 2;

                builder.append(sum);

                i--;
                j--;
            }

            if (carry == 1) {
                builder.append(1);
            }

            return builder.reverse().toString();
        }
    }
}
