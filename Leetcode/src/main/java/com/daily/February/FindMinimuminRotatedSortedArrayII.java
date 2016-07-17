package com.daily.February;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p/>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p/>
 * Find the minimum element.
 */
public class FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                return nums[i];
            }
        }
        return min;
    }
}
