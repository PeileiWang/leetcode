package leet.leet41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/04/17 21:20
 **/
public class A47 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.permuteUnique(nums);
        System.out.println(result);
    }

    private static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> resultList = new ArrayList<>();

            Arrays.sort(nums);

            helper(0, nums, new boolean[nums.length], resultList, new ArrayList<>());

            return resultList;
        }

        private void helper(int step, int[] nums, boolean[] usedArray, List<List<Integer>> resultList, List<Integer> result) {
            if (step == nums.length) {
                resultList.add(new ArrayList<>(result));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                /*
                 如果当前字符被使用过 或者
                 （整体思路用一句话表示，两数相同时，前面的数据没插入，后面数据也不会插入）
                 当前一个数没有递归时（!vis[i - 1]），则当前数据不递归（continue），
                 这条规则保证了递归过程中，相同数据加入递归的顺序始终为坐标位置的顺序，即相同数据不排序（当然第二条的前提是数组必须排序，使相同的数据相邻，如果有一种方案使得相同的数据相邻，则不排序也是可行的
                 */
                if (usedArray[i] ||
                        (i > 0 && nums[i] == nums[i - 1] && !usedArray[i - 1])) {
                    continue;
                }

                usedArray[i] = true;
                result.add(nums[i]);

                helper(step + 1, nums, usedArray, resultList, result);

                result.remove(step);
                usedArray[i] = false;
            }
        }

        private void helper2(int step, int[] nums, boolean[] usedArray, List<List<Integer>> resultList, List<Integer> result) {
            if (step == nums.length) {
                resultList.add(new ArrayList<>(result));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                /*
                 如果当前字符被使用过 或者
                 （整体思路用一句话表示，两数相同时，前面的数据没插入，后面数据也不会插入）
                 当前一个数没有递归时（!vis[i - 1]），则当前数据不递归（continue），
                 这条规则保证了递归过程中，相同数据加入递归的顺序始终为坐标位置的顺序，即相同数据不排序（当然第二条的前提是数组必须排序，使相同的数据相邻，如果有一种方案使得相同的数据相邻，则不排序也是可行的
                 */
                if (usedArray[i]) {
                    continue;
                }

                usedArray[i] = true;
                result.add(nums[i]);

                helper(step + 1, nums, usedArray, resultList, result);

                result.remove(step);
                usedArray[i] = false;
            }
        }
    }
}
