package leet.leet21_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/05/05 14:54
 **/
public class A40 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }

    private static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            Arrays.sort(candidates);

            List<List<Integer>> resultList = new ArrayList<>();

            dfs(resultList, candidates, target, new ArrayList<>(), 0, 0);

            return resultList;
        }

        private void dfs(List<List<Integer>> resultList,
                         int[] candidates,
                         int target,
                         List<Integer> tempList,
                         int step,
                         int begin) {
            if (target == 0) {
                resultList.add(new ArrayList<>(tempList));
                return;
            }

            for (int i = begin; i < candidates.length; i++) {

                // 如果当前数跟前一个相同，表示已经处理过，跳过
                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                int curTarget = target - candidates[i];
                if (curTarget < 0) {
                    return;
                }

                tempList.add(candidates[i]);

                dfs(resultList, candidates, curTarget, tempList, step + 1, i + 1); // 数不能重复使用，所以begin为i+1

                tempList.remove(step);

            }
        }
    }
}
