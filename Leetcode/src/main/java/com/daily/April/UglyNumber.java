package com.daily.April;

/**
 * Created by luckyyflv on 16-4-21.
 * <p/>
 * Write a program to check whether a given number is an ugly number.
 * <p/>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another
 * prime factor 7.
 * <p/>
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {

    //借鉴他人的方法，非常巧妙。。。网上总有一些方法让你叹为观止
    public boolean isUgly(int num) {
        if (num < 1) return false;
        int[] divisors = {2, 3, 5};

        for (int d : divisors) {
            while (num % d == 0) {
                num /= d;
            }
        }
        return num == 1;
    }
}