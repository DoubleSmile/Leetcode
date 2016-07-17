package com.daily.February;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p/>
 * Solve it without division and in O(n).
 * <p/>
 * For example, given [1,2,3,4], return [24,12,8,6].
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];

        int leftMult = 1, rightMult = 1;

        for (int i = len - 1; i >= 0; i--) {
            output[i] = rightMult;
            rightMult *= nums[i];
        }
        for (int j = 0; j < len; j++) {
            output[j] *= leftMult;
            leftMult *= nums[j];

        }

        return output;
    }
}
