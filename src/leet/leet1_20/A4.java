package leet.leet1_20;

/**
 * @author: wangpeilei
 * @date: 2021/04/10 20:24
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 **/
public class A4 {

    /**
     * 正常思路，两个有序数组，二路归并
     */
    private static class SolutionA {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] resultNums;
            if (nums1.length == 0) {
                resultNums = nums2;
            } else if (nums2.length == 0) {
                resultNums = nums1;
            } else {
                int i = 0;
                int j = 0;
                resultNums = new int[nums1.length + nums2.length];

                int cur = 0;

                while (i < nums1.length && j < nums2.length) {
                    if (nums1[i] <= nums2[j]) {
                        resultNums[cur++] = nums1[i++];
                    } else {
                        resultNums[cur++] = nums2[j++];
                    }
                }

                while (i < nums1.length) {
                    resultNums[cur++] = nums1[i++];
                }

                while (j < nums2.length) {
                    resultNums[cur++] = nums2[j++];
                }
            }

            if (resultNums.length % 2 == 0) {
                return ((double) (resultNums[resultNums.length / 2 - 1] + resultNums[resultNums.length / 2])) / 2;
            } else {
                return resultNums[resultNums.length / 2];
            }
        }
    }

    /**
     * 正常思路
     */
    private static class SolutionB {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            return 0;
        }
    }
}
