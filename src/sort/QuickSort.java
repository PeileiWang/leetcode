package sort;

import java.util.Arrays;

/**
 * @author: wangpeilei
 * @date: 2021/05/01 15:17
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 1, 0, 2, 9, 8, 6, 7, 5};

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

            // 找到一个比key小的位置
            while (i < j && nums[j] >= key) {
                j--;
            }

            // 找到一个比key大的位置
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
