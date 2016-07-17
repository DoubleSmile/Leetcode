package com.daily.April;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by luckyyflv on 16-4-11.
 *
 * Given a m x n matrix, if an element is 0,
 * set its entire row and column to 0. Do it in place.
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        int row = matrix.length;
        int column = matrix[0].length;
        Set<Integer> zeroRow = new HashSet<Integer>();
        Set<Integer> zeroColumn = new HashSet<Integer>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow.add(i);
                    zeroColumn.add(j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (zeroRow.contains(i)) {
                    Arrays.fill(matrix[i], 0);
                    break;
                }
                if (zeroColumn.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}