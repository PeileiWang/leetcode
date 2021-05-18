package leet.leet41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/05/13 22:58
 **/
public class A56 {

    private static class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) {
                return intervals;
            }
            Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));

            List<int[]> merged = new ArrayList<>();
            for (int[] interval : intervals) {
                int left = interval[0], right = interval[1];
                if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
                    merged.add(new int[]{left, right});
                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }


        // 左边界在小于等于前面的右边界的最大值，可合并。
        // 当前的左小于等于之前的最大的右
        public int[][] mergeV2(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

            List<int[]> result = new ArrayList<>();

            int left = 0;
            while (left < intervals.length) {
                int tempMin = intervals[left][0];
                int tempMax = intervals[left][1];

                int right = left + 1;

                // intervals[right][0] <= tempMax  如果后面的左边界小于等于前面一批的右边界的最大值，则可以合并，此时更新最大值，且right++
                for (; right < intervals.length && intervals[right][0] <= tempMax; right++) {
                    tempMax = Math.max(tempMax, intervals[right][1]);
                }

                result.add(new int[]{tempMin, tempMax});
                left = right;
            }

            return result.toArray(new int[result.size()][]);
        }
    }
}
