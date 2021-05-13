package leet.leet41_60;

import java.util.*;

/**
 * @author: wangpeilei
 * @date: 2021/05/13 22:08
 **/
public class A49 {


    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strings = new String[]{"ddddddddddg", "dgggggggggg"};

        List<List<String>> lists = solution.groupAnagrams(strings);

        System.out.println(lists);
    }


    private static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> resultMap = new HashMap<>();

            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);

                String s = new String(chars);

                if (resultMap.containsKey(s)) {
                    resultMap.get(s).add(str);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    resultMap.put(s, list);
                }
            }

            return new ArrayList<>(resultMap.values());
        }
    }
}
