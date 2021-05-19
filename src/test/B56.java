package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/05/19 11:23
 **/
public class B56 {
    private static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

            List<int[]> resultList = new ArrayList<>();

            for (int i = 0; i < intervals.length; ) {
                int left = intervals[i][0];

                int rightMax = intervals[i][1];

                int j = i + 1;
                for (; j < intervals.length && intervals[j][0] <= rightMax; j++) {
                    rightMax = Math.max(rightMax, intervals[j][1]);
                }

                resultList.add(new int[]{left, rightMax});
                i = j;
            }

            return resultList.toArray(new int[resultList.size()][]);
        }
    }
}
