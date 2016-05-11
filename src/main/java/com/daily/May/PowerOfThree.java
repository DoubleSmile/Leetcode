package com.daily.May;

/**
 * Created by luckyyflv on 16-5-11.
 * <p/>
 * Given an integer, write a function to determine if it is a power of three.
 */
public class PowerOfThree {
    //这个方法这么简单我就不用过多介绍了吧。。
    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        double r = Math.log10(n) / Math.log10(3);
        if (r % 1 == 0)
            return true;
        else
            return false;
    }
}