package leet.leet21_40;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: wangpeilei
 * @date: 2021/05/05 10:52
 **/
public class A37 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solution.solveSudoku(board);
    }

    private static class Solution {
        public void solveSudoku(char[][] board) {
            // 行
            List<Set<Character>> rowSetList = new ArrayList<>(9);

            // 列
            List<Set<Character>> columnSetList = new ArrayList<>(9);

            // 九宫格区域 row + column / 3。 其中row 和 column从 0 开始
            List<Set<Character>> unionSetList = new ArrayList<>(9);

            for (int i = 0; i < 9; i++) {
                rowSetList.add(new HashSet<>());
                columnSetList.add(new HashSet<>());
                unionSetList.add(new HashSet<>());
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != '.') {
                        rowSetList.get(i).add(board[i][j]);
                        columnSetList.get(j).add(board[i][j]);
                        unionSetList.get(i / 3 * 3 + j / 3).add(board[i][j]);
                    }
                }
            }

            char[] chars = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
            char[][] res = new char[9][9];
            dfs(board, chars, rowSetList, columnSetList, unionSetList, 0, 0, res);

            for (int i = 0; i < board.length; i++) {
                System.arraycopy(res[i], 0, board[i], 0, board[i].length);
            }
        }

        private void dfs(char[][] board,
                         char[] chars,
                         List<Set<Character>> rowSetList,
                         List<Set<Character>> columnSetList,
                         List<Set<Character>> unionSetList,
                         int row,
                         int column,
                         char[][] res) {
            if (column == 9) {
                column = 0;
                row++;
                if (row == 9) {
                    for (int i = 0; i < board.length; i++) {
                        System.arraycopy(board[i], 0, res[i], 0, board.length);
                    }
                    return;
                }
            }

            Set<Character> rowSet = rowSetList.get(row);
            Set<Character> columnSet = columnSetList.get(column);
            Set<Character> unionSet = unionSetList.get(row / 3 * 3 + column / 3);

            if (board[row][column] == '.') {
                for (char c : chars) {
                    if (isValid(c, rowSet, columnSet, unionSet)) {
                        board[row][column] = c;
                        rowSet.add(c);
                        columnSet.add(c);
                        unionSet.add(c);

                        dfs(board, chars, rowSetList, columnSetList, unionSetList, row, column + 1, res);


                        board[row][column] = '.';
                        rowSet.remove(c);
                        columnSet.remove(c);
                        unionSet.remove(c);
                    }
                }
            } else {
                dfs(board, chars, rowSetList, columnSetList, unionSetList, row, column + 1, res);
            }
        }

        private boolean isValid(char c, Set<Character> rowSet, Set<Character> columnSet, Set<Character> unionSet) {
            return !rowSet.contains(c) && !columnSet.contains(c) && !unionSet.contains(c);
        }

    }
}
