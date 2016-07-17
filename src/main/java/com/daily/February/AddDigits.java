package com.daily.February;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p/>
 * For example:
 * <p/>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */
public class AddDigits {
    public int addDigits(int num) {
        if (num < 0) {
            return -1;
        } else if (num == 0) {
            return 0;
        } else {
            return num % 9 == 0 ? 9 : num % 9;
        }
    }
}
