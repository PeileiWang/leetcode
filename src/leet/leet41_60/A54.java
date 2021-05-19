package leet.leet41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/05/19 22:01
 **/
public class A54 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> resultList = new ArrayList<>();

            int rowMin = 0;
            int rowMax = matrix.length - 1;

            int columnMin = 0;
            int columnMax = matrix[0].length - 1;

            // 1、尽可能多的遍历
            // 2、考虑单行和单列情况

            while (rowMin <= rowMax && columnMin <= columnMax) {
                for (int i = columnMin; i <= columnMax; i++) {
                    resultList.add(matrix[rowMin][i]);
                }

                for (int i = rowMin + 1; i <= rowMax; i++) {
                    resultList.add(matrix[i][columnMax]);
                }

                // 不是单行或者单列情况。如果是单行或者单列情况，上面的已经遍历完成了
                if (rowMin < rowMax && columnMin < columnMax) {
                    for (int i = columnMax - 1; i >= columnMin; i--) {
                        resultList.add(matrix[rowMax][i]);
                    }

                    for (int i = rowMax - 1; i > columnMin; i--) {
                        resultList.add(matrix[i][columnMin]);
                    }
                }

                rowMin++;
                rowMax--;
                columnMin++;
                columnMax--;
            }


            return resultList;
        }
    }
}
