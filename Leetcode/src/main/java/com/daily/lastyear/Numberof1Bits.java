package com.daily.lastyear;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * <p/>
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        if (n < Integer.MIN_VALUE)
            return -1;
        String b_string = Integer.toBinaryString(n);
        return b_string.replace("0", "").length();
    }
}
