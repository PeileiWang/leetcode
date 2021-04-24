package leet.leet21_40;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/04/24 20:14
 **/
public class A22 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.generateParenthesis(3);
        System.out.println(list);
    }

    private static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> resultList = new ArrayList<>();

            dfs(resultList, n, n, new char[2 * n], 0);

            return resultList;
        }

        private void dfs(List<String> resultList, int leftNum, int rightNum, char[] curArray, int step) {
            if (leftNum == 0 && rightNum == 0) {
                resultList.add(new String(curArray));
                return;
            }

            if (leftNum < rightNum) {
                if (leftNum > 0) {
                    curArray[step] = '(';
                    dfs(resultList, leftNum - 1, rightNum, curArray, step + 1);
                }
                curArray[step] = ')';
                dfs(resultList, leftNum, rightNum - 1, curArray, step + 1);
            } else if (leftNum == rightNum) {
                curArray[step] = '(';
                dfs(resultList, leftNum - 1, rightNum, curArray, step + 1);
            }
        }
    }
}
