package leet.leet61_80;

/**
 * @author: wangpeilei
 * @date: 2021/06/06 16:59
 **/
public class A75 {

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i >= left && i <= right) {
            if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
            } else if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
                if (i <= left) i = left;
            } else {
                i++;
            }
        }
    }
}
