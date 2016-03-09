package com.daily.February;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Write an algorithm to determine if a number is "happy".
 * <p/>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p/>
 * Example: 19 is a happy number
 * <p/>
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    List<Integer> list = new ArrayList<Integer>();

    public boolean isHappy(int n) {
        int temp = getResult(n);
        if (temp == 1) {
            return true;
        } else {
            if (list.contains(temp)) {
                return false;
            } else {
                list.add(temp);
                return isHappy(temp);
            }
        }
    }

    public int getResult(int number) {
        int sum = 0;
        int y = 0;
        while ((number / 10) != 0) {
            sum += power(number % 10);
            number = number / 10;
        }
        sum += power(number);
        return sum;
    }

    public int power(int a) {
        return a * a;
    }
}
