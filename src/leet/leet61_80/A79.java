package leet.leet61_80;

/**
 * @author: wangpeilei
 * @date: 2021/06/18 16:11
 **/
public class A79 {

    public static void main(String[] args) {
        char[][] board = new char[3][];
        board[0] = new char[]{'A', 'B', 'C', 'E'};
        board[1] = new char[]{'S', 'F', 'C', 'S'};
        board[2] = new char[]{'A', 'D', 'E', 'F'};

        String word = "ABCCED";

        Solution solution = new Solution();
        solution.exist(board, word);
        System.out.println(1);

    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            int h = board.length, w = board[0].length;
            boolean[][] visited = new boolean[h][w];

            char[] chars = word.toCharArray();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == chars[0] && dfs(board, chars, i, j, visited, 0)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean dfs(char[][] board, char[] chars, int i, int j, boolean[][] visited, int step) {

            if (chars[step] != board[i][j]) {
                return false;
            }

            if (step == chars.length - 1) {
                return true;
            }

            boolean res = false;
            visited[i][j] = true;

            if (j + 1 < board[0].length && !visited[i][j + 1]) {
                if (dfs(board, chars, i, j + 1, visited, step + 1)) {
                    res = true;
                }
            }

            if (!res && j - 1 >= 0 && !visited[i][j - 1]) {
                if (dfs(board, chars, i, j - 1, visited, step + 1)) {
                    res = true;
                }
            }

            if (!res && i + 1 < board.length && !visited[i + 1][j]) {
                if (dfs(board, chars, i + 1, j, visited, step + 1)) {
                    res = true;
                }
            }

            if (!res && i - 1 >= 0 && !visited[i - 1][j]) {
                if (dfs(board, chars, i - 1, j, visited, step + 1)) {
                    res = true;
                }
            }

            visited[i][j] = false;

            return res;
        }
    }
}
