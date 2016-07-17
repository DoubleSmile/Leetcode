package com.daily.April;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckyyflv on 16-4-28.
 * <p/>
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p/>
 * For example, given k = 3,
 * Return [1,3,3,1].
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0) return list;
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        if (rowIndex == 0) return firstRow;
        firstRow.add(1);
        if (rowIndex == 1) return firstRow;
        List<Integer> last = getRow(rowIndex - 1);
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        result.add(1);
        for (int i = 1; i < last.size(); i++) {
            result.add(i, last.get(i - 1) + last.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        PascalsTriangleII Pascl = new PascalsTriangleII();
        List<Integer> list = Pascl.getRow(10);
        for (int i : list) {
            System.out.println(i);
        }
    }
}