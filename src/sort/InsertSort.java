package sort;

import java.util.Arrays;

/**
 * @author: wangpeilei
 * @date: 2021/04/30 09:29
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 0, 3, 2, 5, 1, 6, 34, 32, 543, 23, 34};

        insertSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 每次只交换相邻的元素
     * 每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序
     * 插入先认为第一个数有序，从第二个数开始循环。内层循环为逆循环，将依次往前查找，并交换位置
     * 类似每次从桌面拿一张扑克牌，然后插入到有序的数组中
     *
     * @param nums
     */
    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }
}
