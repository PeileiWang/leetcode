package sort;

import java.util.Arrays;

/**
 * @author: wangpeilei
 * @date: 2021/04/30 09:00
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 0, 3, 2, 5, 1, 6, 34, 32, 543, 23, 34};

        selectSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 从数组中选择最小元素，将它与数组的第一个元素交换位置。再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。
     * 不断进行这样的操作，直到将整个数组排序
     * 选择排序，外层一层循环，内层每次找出剩余的最小的值的位置，然后交换 num[i] 和 num[j]
     * @param nums
     */
    private static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minPos]) {
                    minPos = j;
                }
            }

            int temp = nums[minPos];
            nums[minPos] = nums[i];
            nums[i] = temp;
        }
    }
}
