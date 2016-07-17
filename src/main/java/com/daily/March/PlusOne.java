package com.daily.March;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by luckyyflv on 16-3-31.
 * <p/>
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * <p/>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p/>
 * Subscribe to see which companies asked this question
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits == null) {
            int[] res = {1};
            return res;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : digits) {
            sb.append(i);
        }
        BigDecimal decimal = new BigDecimal(sb.toString());
        decimal = decimal.add(new BigDecimal(1));
        String result = String.valueOf(decimal.toString());
        int[] array = new int[result.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = result.charAt(i) - '0';
        }
        return array;
    }

}
