package com.daily.February;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p/>
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int tempSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tempSum <= 0) {
                tempSum = nums[i];
            } else {
                tempSum += nums[i];
            }
            if (tempSum > maxSum) maxSum = tempSum;
        }
        return maxSum;

    }
}