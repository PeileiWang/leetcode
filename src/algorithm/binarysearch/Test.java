package algorithm.binarysearch;

/**
 * @author: wangpeilei
 * @date: 2021/04/18 15:20
 **/
public class Test {
    public static void main(String[] args) {

    }

    /**
     * 左闭右闭区间
     *
     * @param nums
     * @param target
     * @return
     */
    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 防溢出

            if (mid == target) {
                return mid;
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 寻找左边界的二分查找，左闭右开区间
     *
     * @param nums
     * @param target
     * @return 小于target的元素有result个
     */
    private static int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 区间为空的时候退出
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防溢出

            if (nums[mid] < target) {
                // 搜索区间变为[mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为[left, right-1]
                right = mid - 1;
            } else {
                // 收缩右边界
                right = mid - 1;
            }
        }

        // 退出循环时left > right，检查left是否越界
        // 同时检查left是否为target，因为target可能在两个数范围之间
        if (left >= nums.length || nums[left] == target) {
            return -1;
        }
        return left;
    }

    private static int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 区间为空的时候退出
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防溢出

            if (nums[mid] < target) {
                // 搜索区间变为[mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为[left, right-1]
                right = mid - 1;
            } else {
                // 固定右区间，收缩左边界
                left = mid + 1;
            }
        }

        // 退出循环时left > right，检查right是否越界-1
        // 同时检查right是否为target，比如target<最小值，right为-1
        if (right < 0 || nums[right] == target) {
            return -1;
        }
        return left;
    }
}
