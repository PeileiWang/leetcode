package sort;

import java.util.Arrays;

/**
 * @author: wangpeilei
 * @date: 2021/04/10 20:56
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 0, 3, 2, 5, 1, 6, 34, 32, 543, 23, 34};

//        int[] result = bubbleSort(nums);
//        System.out.println(Arrays.toString(result));

        System.out.println("-----------------");
        int[] result1 = mergeSort(nums);
        System.out.println("mergesort:" + Arrays.toString(result1));
    }

    private static int[] mergeSort(int[] nums) {
        int[] temp = new int[nums.length];

        mergeSortInner(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private static void mergeSortInner(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSortInner(nums, left, mid, temp);
            mergeSortInner(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        // left -> mid
        // mid+1 -> right

        int curLeft = left;

        int pos = 0;

        int rightBegin = mid + 1;

        while (left <= mid && rightBegin <= right) {
            if (nums[left] < nums[rightBegin]) {
                temp[pos++] = nums[left++];
            } else {
                temp[pos++] = nums[rightBegin++];
            }
        }

        while (left <= mid) {
            temp[pos++] = nums[left++];
        }

        while (rightBegin <= right) {
            temp[pos++] = nums[rightBegin++];
        }

        pos = 0;
        while (curLeft <= right) {
            nums[curLeft++] = temp[pos++];
        }
    }

    /**
     * 冒泡排序
     *
     * @param nums
     * @return
     */
    private static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {

            int tmp;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        return nums;
    }
}
