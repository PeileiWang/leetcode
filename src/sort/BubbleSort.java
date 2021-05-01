package sort;

import java.util.Arrays;

/**
 * @author: wangpeilei
 * @date: 2021/04/30 09:07
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 0, 3, 2, 5, 1, 6, 34, 32, 543, 23, 34};

        bubbleSort(nums);

        bubbleSortPerf(nums);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 每次将最大的数放到最后。下一次遍历只需遍历从0到上次最大的数之前的位置
     *
     * @param nums
     */
    private static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化点：在每次对比一轮时，如果没有发生过交换，证明数组已经有序
     * @param nums
     */
    private static void bubbleSortPerf(int[] nums) {
        boolean sorted = false;
        for (int i = nums.length - 1; i >= 0 && !sorted; i--) {
            sorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    sorted = false;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
