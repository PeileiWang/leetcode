package leet.leet41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangpeilei
 * @date: 2021/04/17 22:41
 * N皇后问题
 **/
public class A51 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(10);
        System.out.println(lists);
    }

    private static class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] results = new char[n][n];
            for (char[] chars : results) {
                Arrays.fill(chars, '.');
            }

            List<List<String>> resultList = new ArrayList<>();

            solveNQueensHelper(0, results, resultList);
            return resultList;
        }

        /**
         * 从行开始
         *
         * @param row
         * @param results
         * @param resultList
         */
        private void solveNQueensHelper(int row, char[][] results, List<List<String>> resultList) {
            if (row == results.length) {
                List<String> result = new ArrayList<>();
                for (char[] chars : results) {
                    String str = new String(chars);
                    result.add(str);
                }
                resultList.add(new ArrayList<>(result));
                return;
            }

            // row行对应的一列
            char[] chars = results[row];
            for (int i = 0; i < chars.length; i++) {
                if (!isValid(row, i, results, results.length)) {
                    continue;
                }

                chars[i] = 'Q';
                solveNQueensHelper(row + 1, results, resultList);
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
//            results[row][column] = 'Q';

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
