package test;

/**
 * @author: wangpeilei
 * @date: 2021/05/30 22:42
 **/
public class FindDupNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,1,0};

        int dupNumber = findDupNumber(nums);

        System.out.println(dupNumber);
    }

    private static int findDupNumber(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < 0 || nums[i] > length - 1) {
                return -1;
            }

            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }

                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }

        return -1;
    }
}
