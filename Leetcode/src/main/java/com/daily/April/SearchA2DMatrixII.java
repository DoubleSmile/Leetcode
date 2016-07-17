package com.daily.April;

/**
 * Created by luckyyflv on 16-4-19.
 * <p/>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p/>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * <p/>
 * Consider the following matrix:
 * <p/>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p/>
 * Given target = 20, return false.
 */
public class SearchA2DMatrixII {
    //这种是我们最容易想到的方法，事件复杂度也只有(m+n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                i++;
            else
                j--;
        }
        return false;
    }

}
