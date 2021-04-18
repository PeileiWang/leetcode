package leet.leet1_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangpeilei
 * @date: 2021/04/12 23:13
 **/
public class A17 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("23");
    }

    private static class Solution {
        /**
         * 深度优先搜索
         *
         * @param digits
         * @return
         */
        public List<String> letterCombinations(String digits) {
            Map<Character, char[]> map = new HashMap<>();
            map.put('2', new char[]{'a', 'b', 'c'});
            map.put('3', new char[]{'d', 'e', 'f'});
            map.put('4', new char[]{'g', 'h', 'i'});
            map.put('5', new char[]{'j', 'k', 'l'});
            map.put('6', new char[]{'m', 'n', 'o'});
            map.put('7', new char[]{'p', 'q', 'r', 's'});
            map.put('8', new char[]{'t', 'u', 'v'});
            map.put('9', new char[]{'w', 'x', 'y', 'z'});


            List<String> result = new ArrayList<>();

            if (digits.length() == 0) {
                return result;
            }

            // 保存单个结果的arr
            char[] arr = new char[digits.length()];
            dfs(0, result, arr, map, digits.toCharArray());
            return result;
        }


        private void dfs(int index, List<String> result, char[] res, Map<Character, char[]> digitMap, char[] digitCharArray) {
            if (index == digitCharArray.length) {
                result.add(new String(res));
                return;
            }

            char c = digitCharArray[index];

            char[] chars = digitMap.get(c);

            for (char aChar : chars) {
                res[index] = aChar;
                dfs(index + 1, result, res, digitMap, digitCharArray);
            }
        }


        private void helper(String digits, int index, Map<Character, char[]> map, List<String> result, char[] arr) {

            // 如果index与string长度一致，则递归结束
            if (index == digits.length()) {
                result.add(new String(arr));
                return;
            }

            // 找出index的num
            char num = digits.charAt(index);

            // 找出这个num对应的字符array
            char[] candidates = map.get(num);

            // 对字符array遍历
            for (int i = 0; i < candidates.length; i++) {

                // 下标为index的为arr值 ，为字符array的i
                arr[index] = candidates[i];
                helper(digits, index + 1, map, result, arr);
            }
        }

        /**
         * 回溯
         *
         * @param digits
         * @return
         */
//        public List<String> letterCombinationsV2(String digits) {
//            Map<Character, String> map = new HashMap<>();
//            map.put('2', "abc");
//            map.put('3', "def");
//            map.put('4', "ghi");
//            map.put('5', "jkl");
//            map.put('6', "mno");
//            map.put('7', "pqrs");
//            map.put('8', "tuv");
//            map.put('9', "wxyz");
//
//
//        }
    }
}
