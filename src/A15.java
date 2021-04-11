import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/04/11 22:53
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 **/
public class A15 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{-1, 0, 1, 2, -1, -4};
        solution.threeSum(ints);
    }

    /**
     * -a=b+c
     * 排序，转化成两数相加等于某个数，排序后用,对每个target，从target位置之后找两个元素，相加是否等于target。双指针
     */
    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> integerListList = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {

                // 如果num[i] 大于0，则后面不可能相加等于负数
                if (nums[i] > 0) {
                    return integerListList;
                }

                // 如果当前位置元素跟之前的重复，表示已经计算过，不用再次计算，为了去重
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int target = -nums[i];

                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] < target) {
                        left++;
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {  // 如果相等

                        // 处理左边的相等元素，直到指到左边最后一个相等的元素
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        // 处理右边的相等元素，直到指到右边最前一个相等的元素
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        List<Integer> integers = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                        integerListList.add(integers);

                        left++;
                        right--;
                    }
                }
            }

            return integerListList;
        }
    }
}
