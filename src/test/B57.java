package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/05/19 12:14
 **/
public class B57 {
    public static void main(String[] args) {

    }

    private static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            int left = newInterval[0];
            int right = newInterval[1];

            List<int[]> resultList = new ArrayList<>();
            boolean addFlag = false;
            for (int[] interval : intervals) {

                if (addFlag) {
                    resultList.add(interval);
                    continue;
                }

                int curLeft = interval[0];
                int curRight = interval[1];

                if (curLeft > right) {
                    resultList.add(new int[]{left, right});
                    addFlag = true;
                    resultList.add(interval);
                } else if (curRight < left) {
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
