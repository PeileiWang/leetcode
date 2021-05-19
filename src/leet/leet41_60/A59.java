package leet.leet41_60;

/**
 * @author: wangpeilei
 * @date: 2021/05/19 23:18
 **/
public class A59 {

    private static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];

            int temp = 1;

            int rowMin = 0;
            int rowMax = n - 1;

            int columnMin = 0;
            int columnMax = n - 1;

            // 1、尽可能多的遍历
            // 2、考虑单行和单列情况

            while (rowMin <= rowMax && columnMin <= columnMax) {
                for (int i = columnMin; i <= columnMax; i++) {
                    matrix[rowMin][i] = temp++;
                }

                for (int i = rowMin + 1; i <= rowMax; i++) {
                    matrix[i][columnMax] = temp++;
                }

                // 不是单行或者单列情况。如果是单行或者单列情况，上面的已经遍历完成了
                if (rowMin < rowMax && columnMin < columnMax) {
                    for (int i = columnMax - 1; i >= columnMin; i--) {
                        matrix[rowMax][i] = temp++;
                    }

                    for (int i = rowMax - 1; i > columnMin; i--) {
                        matrix[i][columnMin] = temp++;
                    }
                }

                rowMin++;
                rowMax--;
                columnMin++;
                columnMax--;
            }


            return matrix;
        }
    }
}
