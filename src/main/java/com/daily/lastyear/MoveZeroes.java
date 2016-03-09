package com.daily.lastyear;

/**
 * Created by luckyyflv on 16-3-9.
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int zoreCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zoreCount++;
                continue;
            }
            if (zoreCount == 0) {
                continue;
            }
            nums[i - zoreCount] = nums[i];
            nums[i] = 0;
        }

    }
}
