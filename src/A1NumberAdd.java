import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangpeilei
 * @date: 2021/04/08 22:59
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 **/
public class A1NumberAdd {
}

/**
 * 使用map存下数值和位置。判断时只需判断target减去遍历的当前值是否在map中
 */
class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    result[0] = i;
//                    result[1] = j;
//                }
//            }
//        }
//
//        return result;
//    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return result;
    }
}
