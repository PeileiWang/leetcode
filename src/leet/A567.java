package leet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangpeilei
 * @date: 2021/04/18 17:45
 **/
public class A567 {
    public static void main(String[] args) {
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        Solution solution = new Solution();
        boolean b = solution.checkInclusion(s1, s2);
        System.out.println(b);
    }

    private static class Solution {
        /**
         * s1的排列是s2的子串
         *
         * @param s1
         * @param s2
         * @return
         */
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> targetMap = new HashMap<>();
            Map<Character, Integer> tempMap = new HashMap<>();

            for (char c : s1.toCharArray()) {
                targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
                tempMap.put(c, 0);
            }

            int count = 0;

            int left = 0, right = 0;
            char[] charArray = s2.toCharArray();
            while (right < s2.length()) {
                char c = charArray[right];
                right++;

                if (tempMap.containsKey(c)) {
                    tempMap.put(c, tempMap.get(c) + 1);
                    if (tempMap.get(c).equals(targetMap.get(c))) {
                        count++;
                    }
                }

                // 找到解之后优化解
                while (count == targetMap.size()) {
                    if (right - left == s1.length()) {
                        return true;
                    }
                    char leftValue = charArray[left];
                    left++;
                    if (tempMap.containsKey(leftValue)) {
                        tempMap.put(leftValue, tempMap.get(leftValue) - 1);
                        if (tempMap.get(leftValue) < targetMap.get(leftValue)) {
                            count--;
                        }
                    }
                }
            }

            return false;
        }
    }
}
