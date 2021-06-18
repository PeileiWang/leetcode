package leet.leet41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/05/18 22:51
 **/
public class A57 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[5][];
        intervals[0] = new int[]{1, 2};
        intervals[1] = new int[]{3, 5};
        intervals[2] = new int[]{6, 7};
        intervals[3] = new int[]{8, 10};
        intervals[4] = new int[]{12, 16};

        int[] newInterval = new int[]{4, 8};

        int[][] insert = solution.insert(intervals, newInterval);
        System.out.println(insert);
    }

    private static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            if (intervals.length == 0) {
                int[][] results = new int[1][];
                results[0] = newInterval;
                return results;
            }

            List<int[]> resultList = new ArrayList<>();

            // 如果最小值大于已存在区间的最大值，直接返回
            if (newInterval[0] > intervals[intervals.length - 1][1]) {
                resultList.addAll(Arrays.asList(intervals));
                resultList.add(newInterval);
                return resultList.toArray(new int[resultList.size()][]);
            }

            int a = newInterval[0];
            int b = newInterval[1];

            int i = 0;
            boolean findFlag = false;
            while (i < intervals.length) {
                if (findFlag) {
                    resultList.add(intervals[i]);
                    i++;
                    continue;
                }

                int leftValue = intervals[i][0];
                int rightValue = intervals[i][1];

                if (a > rightValue) {
                    resultList.add(intervals[i]);
                    i++;
                    continue;
                }

                int curLeftValue = Math.min(a, leftValue);
                while (i < intervals.length) {
                    leftValue = intervals[i][0];
                    rightValue = intervals[i][1];
                    if (b > rightValue) {
                        i++;
                        if (i == intervals.length) {
                            resultList.add(new int[]{curLeftValue, b});
                        }
                    } else if (b < leftValue) {
                        resultList.add(new int[]{curLeftValue, b});
                        findFlag = true;
                        break;
                    } else {
                        resultList.add(new int[]{curLeftValue, rightValue});
                        findFlag = true;
                        i++;
                        break;
                    }
                }
            }

            return resultList.toArray(new int[resultList.size()][]);
        }


        /*
        由于我们需要保证答案也是按照左端点排序的，因此当我们遇到第一个 满足 的区间时，说明以后遍历到的区间不会与 SS 重叠，并且它们左端点一定会大于 SS 的左端点。此时我们就可以将 SS 加入答案。特别地，如果不存在这样的区间，我们需要在遍历结束后，将 SS 加入答案
         */
        public int[][] insertV2(int[][] intervals, int[] newInterval) {

            int left = newInterval[0];
            int right = newInterval[1];

            List<int[]> resultList = new ArrayList<>();
            boolean addFlag = false;
            for (int[] interval : intervals) {

                if (addFlag) {
                    resultList.add(interval);
                    continue;
                }

                int curLeft = interval[0]; // 当前左值
                int curRight = interval[1]; // 当前右值

                // 当前左大于右
                if (curLeft > right) {
                    resultList.add(new int[]{left, right});
                    addFlag = true;
                    resultList.add(interval);
                } else if (curRight < left) { // 当前右小于左
                    resultList.add(interval);
                } else { // 区间合并
                    left = Math.min(left, curLeft);
                    right = Math.max(right, curRight);
                }
            }

            if (!addFlag) {
                resultList.add(new int[]{left, right});
            }
            return resultList.toArray(new int[resultList.size()][]);
        }
    }
}
