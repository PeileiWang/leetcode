package leet.leet41_60;

import java.util.Arrays;

/**
 * @author: wangpeilei
 * @date: 2021/04/17 23:24
 **/
public class A52 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int totalNQueens = solution.totalNQueens(4);
        System.out.println(totalNQueens);
    }

    private static class Solution {
        public int totalNQueens(int n) {
            char[][] results = new char[n][n];
            for (char[] chars : results) {
                Arrays.fill(chars, '.');
            }

            int[] totalNumArray = new int[1];

            solveNQueensHelper(0, results, totalNumArray);
            return totalNumArray[0];
        }

        private void solveNQueensHelper(int row, char[][] results, int[] totalNumArray) {
            if (row == results.length) {
                totalNumArray[0] = totalNumArray[0] + 1;
                return;
            }

            // row行对应的一列
            char[] chars = results[row];
            for (int i = 0; i < chars.length; i++) {
                if (!isValid(row, i, results, results.length)) {
                    continue;
                }

                chars[i] = 'Q';
                solveNQueensHelper(row + 1, results, totalNumArray);
                chars[i] = '.';
            }
        }

        /**
         * 任何两个皇后都不能处于同一条横行、纵行或斜线上
         *
         * @param row
         * @param column
         * @param results
         * @return
         */
        private boolean isValid(int row, int column, char[][] results, int n) {
            // 查询这一列前面几行是否已有Q
            for (int i = 0; i < row; i++) {
                if (results[i][column] == 'Q') {
                    return false;
                }
            }

            // 右上
            for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
                if (results[i][j] == 'Q') {
                    return false;
                }
            }

            // 左上
            for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
                if (results[i][j] == 'Q') {
                    return false;
                }
            }

            return true;
        }
    }


}
