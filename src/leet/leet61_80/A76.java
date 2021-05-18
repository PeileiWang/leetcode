package leet.leet61_80;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangpeilei
 * @date: 2021/04/18 16:23
 **/
public class A76 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.minWindow("ADOBECODEBANC", "ABC");
        solution.minWindowTest("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    private static class Solution {
        public String minWindow(String s, String t) {
            int left = 0, right = 0;

            char[] targetChars = t.toCharArray();
            Map<Character, Integer> targetMap = new HashMap<>();
            for (char targetChar : targetChars) {
                if (targetMap.containsKey(targetChar)) {
                    targetMap.put(targetChar, targetMap.get(targetChar) + 1);
                } else {
                    targetMap.put(targetChar, 1);
                }
            }

            // char出现的次数
            Map<Character, Integer> tempMap = new HashMap<>();
            for (Character character : targetMap.keySet()) {
                tempMap.put(character, 0);
            }

            int start = 0;
            int minLength = Integer.MAX_VALUE;

            char[] chars = s.toCharArray();

            int count = 0;
            while (right < chars.length) {
                char c = chars[right];
                right++;

                if (!targetMap.containsKey(c)) {
                    continue;
                }

                Integer times = tempMap.get(c);
                tempMap.put(c, times + 1);
                if (tempMap.get(c).equals(targetMap.get(c))) {
                    count++;
                }

                if (count < targetMap.size()) {
                    continue;
                }

                // 缩小窗口
                while (count == targetMap.size()) {
                    int length = right - left;
                    if (length < minLength) {
                        minLength = length;
                        start = left;
                    }

                    char c1 = chars[left];
                    left++;

                    if (!targetMap.containsKey(c1)) {
                        continue;
                    }

                    Integer times1 = tempMap.get(c1);

                    tempMap.put(c1, times1 - 1);

                    if (tempMap.get(c1) < targetMap.get(c1)) {
                        count--;
                    }
                }
            }

            if (minLength == Integer.MAX_VALUE) {
                return "";
            }

            return s.substring(start, start + minLength);
        }

        public String minWindowTest(String s, String t) {
            Map<Character, Integer> windowMap = new HashMap<>();

            Map<Character, Integer> tempMap = new HashMap<>();

            // 1、初始化windowMap
            for (char c : t.toCharArray()) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            }

            char[] chars = s.toCharArray();

            int left = 0, right = 0;
            int matchCount = 0;
            int minLength = Integer.MAX_VALUE;
            int start = 0;
            while (right < chars.length) {
                char temp = chars[right];
                right++;

                if (windowMap.containsKey(temp)) {
                    tempMap.put(temp, tempMap.getOrDefault(temp, 0) + 1);
                    if (tempMap.get(temp).equals(windowMap.get(temp))) {
                        matchCount++;
                    }
                } else {
                    continue;
                }

                while (matchCount == windowMap.size()) {

                    int length = right - left; // 因为right++
                    if (length < minLength) {
                        minLength = length;
                        start = left;
                    }

                    char leftValue = chars[left];
                    left++;

                    if (windowMap.containsKey(leftValue)) {
                        tempMap.put(leftValue, tempMap.get(leftValue) - 1);
                        if (tempMap.get(leftValue) < windowMap.get(leftValue)) {
                            matchCount--;
                        }
                    }
                }
            }

            if (minLength == Integer.MAX_VALUE) {
                return "";
            }

            return s.substring(start, start + minLength);
        }
    }
}
