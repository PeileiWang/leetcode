package leet.leet41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/04/17 19:00
 **/
public class A46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result);
    }

    private static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> resultList = new ArrayList<>();
            boolean[] usedStatus = new boolean[nums.length];

            helper(0, nums, usedStatus, resultList, new ArrayList<>());

            return resultList;
        }

        private void helper(int step, int[] nums, boolean[] usedStatus, List<List<Integer>> resultList, List<Integer> curResList) {
            // 判断结束
            if (step == nums.length) {
                resultList.add(new ArrayList<>(curResList));
                return;
            }

            // 遍历做选择
            for (int i = 0; i < nums.length; i++) {
                if (!usedStatus[i]) { // 当前字符是否被使用
                    curResList.add(nums[i]);
                    usedStatus[i] = true; // 当前字符置为使用

                    helper(step + 1, nums, usedStatus, resultList, curResList);

                    // 用下标移除当前步骤的数字，然后将当前字符的使用状态置为未使用
                    curResList.remove(step);
                    usedStatus[i] = false;
                }
            }
        }
    }
}
