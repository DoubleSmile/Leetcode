package com.daily.April;

import java.util.Arrays;

/**
 * Created by luckyyflv on 16-4-10.
 * <p/>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p/>
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * <p/>
 * Your algorithm should run in O(n2) complexity.
 * <p/>
 * Follow up: Could you improve it to O(n log n) time complexity?
 */


//解决DP问题的核心是找出最有子结构以及最佳状态转移方程，只要找到状态转移方程，问题就可迎刃而解
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, 1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //最佳状态转移方程，核心语句
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, res[i]);
        }
        return max;
    }
}
