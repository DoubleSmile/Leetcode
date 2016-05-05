package com.daily.May;

/**
 * Created by luckyyflv on 16-5-5.
 * <p/>
 * Reverse digits of an integer.
 * <p/>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) result;
    }
}
