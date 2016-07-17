package com.daily.February;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p/>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length < 1)
            return 0;
        int s0 = nums[0];           //robbing
        int s1 = 0;                 //not robbing
        for (int i = 1; i < nums.length; i++) {
            int t = s0;
            s0 = s1 + nums[i];
            s1 = Math.max(t, s1);
        }
        return Math.max(s0, s1);
    }
}
