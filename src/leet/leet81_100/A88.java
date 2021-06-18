package leet.leet81_100;

/**
 * @author: wangpeilei
 * @date: 2021/06/10 16:16
 **/
public class A88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] res = new int[m + n];

            int i = 0, j = 0;
            int k = 0;
            while (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    res[k++] = nums1[i++];
                } else {
                    res[k++] = nums2[j++];
                }
            }

            while (i < m) {
                res[k++] = nums1[i++];
            }
            while (j < n) {
                res[k++] = nums2[j++];
            }

            System.arraycopy(res, 0, nums1, 0, nums1.length);
        }

        public void merge1(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int k = nums1.length - 1;

            while (i >= 0 && j >= 0) {
                if (nums1[i] < nums2[j]) {
                    nums1[k--] = nums1[i--];
                } else {
                    nums1[k--] = nums2[j--];
                }
            }

            while (i >= 0) {
                nums1[k--] = nums1[i--];
            }

            while (j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
