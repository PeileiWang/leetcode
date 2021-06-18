package leet.leet61_80;

/**
 * @author: wangpeilei
 * @date: 2021/06/18 15:51
 **/
public class A73 {

    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean[] row = new boolean[m]; // 标识每行是否有0
            boolean[] col = new boolean[n]; // 标识每列是否有0

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = col[j] = true;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (row[i] || col[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
