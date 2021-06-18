package leet.leet61_80;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/06/09 11:49
 **/
public class A77 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);
    }

    private static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> resultList = new ArrayList<>();

            List<Integer> tempList = new ArrayList<>();
            dfs(n, k, 0, 1, resultList, tempList);
            return resultList;
        }

        private void dfs(int n, int k, int step, int start, List<List<Integer>> resultList, List<Integer> tempList) {
            if (step == k) {
                resultList.add(new ArrayList<>(tempList));
                return;
            }

            if (start + step > n) {
                return;
            }

            for (int i = start; i <= n; i++) {
                tempList.add(i);
                dfs(n, k, step + 1, i + 1, resultList, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
