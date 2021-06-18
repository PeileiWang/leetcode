package leet.leet61_80;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/06/10 17:39
 **/
public class A78 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> resultList = new ArrayList<>();

            resultList.add(new ArrayList<>());

            for (int num : nums) {
                List<List<Integer>> tempList = new ArrayList<>();
                for (List<Integer> integers : resultList) {
                    List<Integer> temp = new ArrayList<>(integers);
                    temp.add(num);
                    tempList.add(temp);
                }
                resultList.addAll(tempList);
            }

            return resultList;
        }

        public List<List<Integer>> subsets2(int[] nums) {
            List<List<Integer>> resultList = new ArrayList<>();

            List<Integer> tempList = new ArrayList<>();
            dfs(nums, tempList, resultList, 0);

            return resultList;
        }

        // 组合用start
        private void dfs(int[] nums, List<Integer> tempList, List<List<Integer>> resultList, int start) {
            // 每一个都需要，所以都加
            resultList.add(new ArrayList<>(tempList));
            if (start == nums.length) {
                return;
            }

            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                dfs(nums, tempList, resultList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
