package leet.leet21_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/05/05 13:50
 **/
public class A39 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }

    private static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> resultList = new ArrayList<>();

            Arrays.sort(candidates);

//            dfs(resultList, candidates, target, new ArrayList<>(), 0, 0);

            dfs1(resultList, candidates, target, new ArrayList<>(), new int[1], 0, 0);

            return resultList;
        }

        /**
         * @param resultList
         * @param candidates
         * @param target
         * @param integers
         * @param step
         * @param begin      下一次循环从哪个数里开始遍历
         *                   <p>
         *                   排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
         *                   组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。
         */
        private void dfs(List<List<Integer>> resultList, int[] candidates, int target, List<Integer> integers, int step, int begin) {
            if (target == 0) {
                resultList.add(new ArrayList<>(integers));
                return;
            }

            if (target > 0) {
                for (int i = begin; i < candidates.length; i++) {
                    int candidate = candidates[i];
                    int curTarget = target - candidate;
                    if (curTarget < 0) {
                        return;
                    }
                    integers.add(candidate);

                    dfs(resultList, candidates, curTarget, integers, step + 1, i);

                    integers.remove(step);
                }
            }
        }

        private void dfs1(List<List<Integer>> resultList, int[] candidates, int target, List<Integer> integers, int[] total, int step, int begin) {
            if (total[0] == target) {
                resultList.add(new ArrayList<>(integers));
            }

            if (total[0] > target) {
                return;
            }

            for (int i = begin; i < candidates.length; i++) {

                int curTotal = total[0] + candidates[i];
                if (curTotal > target) {
                    return;
                }
                total[0] += candidates[i];
                integers.add(candidates[i]);

                dfs1(resultList, candidates, target, integers, total, step + 1, i);

                total[0] -= candidates[i];
                integers.remove(step);
            }
        }
    }
}
