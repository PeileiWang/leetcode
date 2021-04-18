package leet.leet1_20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: wangpeilei
 * @date: 2021/04/09 00:04
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 **/
public class A3 {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstringV("pwwkew");
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {

        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {

            int len = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!set.add(c)) {
                    break;
                }

                len++;
            }

            set.clear();
            max = Math.max(len, max);
        }

        return max;
    }

    public static int lengthOfLongestSubstringV(String s) {

        int max = 0;
        Set<Character> set = new HashSet<>();

        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!set.add(c)) {
                max = Math.max(max, set.size());
                for (int j = pos; j < i; j++) {
                    char c1 = s.charAt(j);

                    if (c1 == c) {
                        pos = j + 1;
                        break;
                    }

                    set.remove(c1);
                }
            }
        }

        max = Math.max(max, set.size());

        return max;
    }

    public static int lengthOfLongestSubstringV2(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int max = 0;

        char[] charArray = s.toCharArray();
        while (right < s.length()) {
            char c = charArray[right];
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char c1 = charArray[left];
                left++;

                window.put(c1, window.get(c1) - 1);
            }

            max = Math.max(max, right - left);
        }

        return max;
    }

}
