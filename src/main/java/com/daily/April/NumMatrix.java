package com.daily.April;

/**
 * Created by luckyyflv on 16-4-13.
 * <p/>
 * Given a 2D matrix matrix, find the sum of the elements inside
 * the rectangle defined by its upper left corner (row1, col1) and
 * lower right corner (row2, col2).
 * <p/>
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by
 * (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * <p/>
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p/>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class NumMatrix {
    /*private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(matrix == null ) return 0;
        int rows=matrix.length;
        int columns=matrix[0].length;
        int sum=0;
        for(int i=row1;i<=row2 && row2 < rows;i++){
            for(int j=col1;j<col2 && col2 < columns;j++){
                sum+=matrix[i][j];
            }
        }
        return sum;
    }*/


    //在这里使用DP操作，以上为非DP操作
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix == null
                || matrix.length == 0
                || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int iMin = Math.min(row1, row2);
        int iMax = Math.max(row1, row2);

        int jMin = Math.min(col1, col2);
        int jMax = Math.max(col1, col2);

        return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];
    }
}
