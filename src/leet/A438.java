package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangpeilei
 * @date: 2021/04/18 18:04
 **/
public class A438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        Solution solution = new Solution();
        List<Integer> anagrams = solution.findAnagrams(s, p);
        System.out.println(anagrams);
    }

    private static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            Map<Character, Integer> targetMap = new HashMap<>();
            Map<Character, Integer> windowMap = new HashMap<>();

            for (char c : p.toCharArray()) {
                targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
                windowMap.put(c, 0);
            }

            int left = 0, right = 0;
            List<Integer> resultList = new ArrayList<>();

            int matchCount = 0;
            char[] charArray = s.toCharArray();

            // 移动右指针
            while (right < s.length()) {
                char c = charArray[right];
                right++;

                // 目标包含此字符
                if (targetMap.containsKey(c)) {
                    // 更新窗口此字符的值
                    windowMap.put(c, windowMap.get(c) + 1);
                    // 判断窗口此字符是否满足target
                    if (windowMap.get(c).equals(targetMap.get(c))) {
                        matchCount++;
                    }
                }

                // 找到解，之后优化解
                while (matchCount == targetMap.size()) {
                    if (right - left == p.length()) {
                        resultList.add(left);
                    }
                    char c1 = charArray[left];
                    left++;

                    if (windowMap.containsKey(c1)) {
                        windowMap.put(c1, windowMap.get(c1) - 1);
                        // 判断去除一个字符后，窗口的值是否满足target
                        if (windowMap.get(c1) < targetMap.get(c1)) {
                            matchCount--;
                        }
                    }
                }
            }

            return resultList;
        }
    }
}
