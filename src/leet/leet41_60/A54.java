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


        public List<Integer> spiralOrder2(int[][] matrix) {
            List<Integer> order = new ArrayList<Integer>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int rows = matrix.length, columns = matrix[0].length;
            int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
            while (left <= right && top <= bottom) {
                for (int column = left; column <= right; column++) {
                    order.add(matrix[top][column]);
                }
                for (int row = top + 1; row <= bottom; row++) {
                    order.add(matrix[row][right]);
                }
                if (left < right && top < bottom) {
                    for (int column = right - 1; column > left; column--) {
                        order.add(matrix[bottom][column]);
                    }
                    for (int row = bottom; row > top; row--) {
                        order.add(matrix[row][left]);
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return order;
        }
    }
}
