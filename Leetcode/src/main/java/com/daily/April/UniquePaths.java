package com.daily.April;

/**
 * Created by luckyyflv on 16-4-28.
 * A robot is located at the top-left corner of a m x n grid
 * (marked 'Start' in the diagram below).
 * <p/>
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below).
 * <p/>
 * How many possible unique paths are there?
 */
public class UniquePaths {

    /*public static int uniquePaths(int m, int n) {
        if(m < 0 || n < 0) return 0;
        if(m == 1) return n-1;
        if(n == 1) return m-1;
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }*/

    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }
        return grid[m - 1][n - 1];
    }

}