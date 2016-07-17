package com.daily.February;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p/>
 * For example,
 * Given the following matrix:
 * <p/>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] array) {
        List<Integer> list = new ArrayList<Integer>();
        int raws = array.length;
        if (raws == 0)
            return list;
        int columns = array[0].length;
        for (int beginR = 0, beginC = 0; raws > 0 && columns > 0; beginR++, beginC++) {
            singleSpiralOrder(array, beginR, beginC, columns, raws, list);
            raws -= 2;
            columns -= 2;
        }
        return list;
    }

    //打印其中的一圈
    public void singleSpiralOrder(int[][] array, int beginR, int beginC, int lenX, int lenY, List list) {

        for (int i = 0; i < lenX - 1; i++) {
            list.add(array[beginR][beginC + i]);
        }
        if (lenY == 1) {
            list.add(array[beginR][beginC + lenX - 1]);
            return;
        }
        for (int i = 0; i < lenY - 1; i++) {
            list.add(array[i + beginR][beginC + lenX - 1]);
        }
        if (lenX == 1) {
            list.add(array[lenY - 1 + beginR][beginC + lenX - 1]);
            return;
        }
        for (int i = beginC + lenX - 1; i > beginC; i--) {
            list.add(array[beginR + lenY - 1][i]);
        }

        for (int i = beginR + lenY - 1; i > beginR; i--) {
            list.add(array[i][beginC]);
        }
    }

}
