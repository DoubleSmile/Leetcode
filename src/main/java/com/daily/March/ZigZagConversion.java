package com.daily.March;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by luckyyflv on 16-3-12.
 * <p/>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p/>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p/>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows < 1) return null;
        if (s == null || s.trim().length() < 1) return null;
        if (numRows == 1) return s;
        int column = s.length() / (2 * numRows - 2) * (numRows - 1);
        if (s.length() % (2 * numRows - 2) != 0 && s.length() % (2 * numRows - 2) <= numRows) {
            column += 1;
        } else if (s.length() % (2 * numRows - 2) != 0 && s.length() % (2 * numRows - 2) > numRows) {
            column = column + 1 + s.length() % (2 * numRows - 2) - numRows;
        }
        char[] ss = s.toCharArray();
        int index = 0;
        char[][] array = new char[column][numRows];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < numRows; j++) {
                int x = i % (numRows - 1);
                if (x == 0) {
                    array[i][j] = ss[index++];
                    //读取完毕
                } else {
                    array[i][numRows - 1 - x] = ss[index++];
                    j = numRows;
                }
            }
        }
        return charArrayToString(array);
    }

    public String charArrayToString(char[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] != 0) {
                    sb.append(array[j][i]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] arg9) {
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 9));

        /*System.out.println(new ZigZagConvesion().charArrayToString(a));*/
    }
}
