package leet.leet61_80;

/**
 * @author: wangpeilei
 * @date: 2021/06/06 17:01
 **/
public class A66 {
    class Solution {
        public int[] plusOne(int[] digits) {

            // 逆序
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] != 9) {
                    digits[i]++;
                    return digits;
                }
                // 等于9的话，就变为0
                digits[i] = 0;
            }

            // 跳出循环了，还未结束，只有一种情况，就是全是9
            int[] temp = new int[digits.length + 1];
            temp[0] = 1;
            return temp;
        }
    }
}
