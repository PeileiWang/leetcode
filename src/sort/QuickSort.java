package sort;

import java.util.Arrays;

/**
 * @author: wangpeilei
 * @date: 2021/05/01 15:17
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 0, 3, 2, 5, 1, 6, 34, 32, 543, 23, 34};

        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int key = nums[left];

        int i = left, j = right;
        while (i < j) {

            while (i < j && nums[j] >= key) {
                j--;
            }

            while (i < j && nums[i] <= key) {
                i++;
            }

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        nums[left] = nums[i];
        nums[i] = key;

        quickSort(nums, j + 1, right);
        quickSort(nums, left, i - 1);

    }

}
