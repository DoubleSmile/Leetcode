package com.daily.February;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p/>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public int climbStairs(int n) {//其实思路很简单，就是要消除尾递归而已
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int index = 2; index <= n; index++) {
            arr[index] = arr[index - 1] + arr[index - 2];
        }
        return arr[n];

    }
}