package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: wangpeilei
 * @date: 2021/05/05 17:57
 **/
public class B15 {
    public static void main(String[] args) {

    }

    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> resultList = new ArrayList<>();

            for (int i = 0; i < nums.length - 2; i++) {
                int a = nums[i];
                if (nums[i] > 0) {
                    return resultList;
                }

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] + a > 0) {
                        right--;
                    } else if (nums[left] + nums[right] + a < 0) {
                        left++;
                    } else {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        List<Integer> integers = Arrays.asList(a, nums[left], nums[right]);
                        resultList.add(integers);
                        left++;
                        right--;
                    }
                }
            }

            return resultList;
        }
    }
}
