package leet.leet61_80;

/**
 * @author: wangpeilei
 * @date: 2021/05/30 23:02
 **/
public class A74 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int bottom = matrix.length - 1;

            int right = matrix[0].length - 1;

            int row = 0;
            int col = right;

            while (row <= bottom && col >= 0) {
                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] > target) {
                    col--;
                } else {
                    row++;
                }
            }

            return false;
        }
    }
}
