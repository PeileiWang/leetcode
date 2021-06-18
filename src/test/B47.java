package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/06/09 16:26
 **/
public class B47 {
    private static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> resultList = new ArrayList<>();

            dfs(resultList, 0, nums, new boolean[nums.length], new ArrayList<>());

            return resultList;
        }

        private void dfs(List<List<Integer>> resultList, int step, int[] nums, boolean[] usedArray, List<Integer> tempList) {
            if (step == nums.length) {
                resultList.add(new ArrayList<>(tempList));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (usedArray[i] || (i > 0 && nums[i] == nums[i - 1] && !usedArray[i - 1])) {
                    continue;
                }

                usedArray[i] = true;
                tempList.add(nums[i]);
                dfs(resultList, step+1, nums, usedArray, tempList);
                tempList.remove(step);
                usedArray[i] = false;
            }
        }
    }
}
