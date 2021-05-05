package leet.leet21_40;

/**
 * @author: wangpeilei
 * @date: 2021/05/05 12:55
 **/
public class A36 {
    private static class Solution {
        public boolean isValidSudoku(char[][] board) {
            // 行
            boolean[][] rows = new boolean[9][9];
            // 列
            boolean[][] columns = new boolean[9][9];
            // 九宫格区域 row + column / 3。 其中row 和 column从 0 开始
            boolean[][] unions = new boolean[9][9];


            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != '.') {
                        if (rows[i][board[i][j] - '0' - 1]) {
                            return false;
                        }
                        rows[i][board[i][j] - '0' - 1] = true;

                        if (columns[j][board[i][j] - '0' - 1]) {
                            return false;
                        }
                        columns[j][board[i][j] - '0' - 1] = true;

                        if (unions[i / 3 * 3 + j / 3][board[i][j] - '0' - 1]) {
                            return false;
                        }
                        unions[i / 3 * 3 + j / 3][board[i][j] - '0' - 1] = true;
                    }
                }
            }

            return true;
        }
    }
}
