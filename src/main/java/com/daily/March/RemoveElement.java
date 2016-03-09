package com.daily.March;

/**
 * Created by luckyyflv on 16-3-10.
 * <p/>
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p/>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 0) return 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[sum++] = nums[i];
            }
        }
        return sum;
    }
}
