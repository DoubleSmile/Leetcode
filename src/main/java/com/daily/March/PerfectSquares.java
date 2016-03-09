package com.daily.March;

/**
 * Created by luckyyflv on 16-3-10.
 * <p/>
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p/>
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] s = new int[n + 1];
        for (int i = 0; i < n + 1; i++) s[i] = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (i == sqrt * sqrt) {
                s[i] = 1;
                continue;

            }
            for (int j = 1; j <= sqrt; j++) {
                if (s[i - j * j] + 1 < s[i]) s[i] = s[i - j * j] + 1;
            }
        }
        return s[n];
    }
}
