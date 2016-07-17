package com.daily.lastyear;

/**
 * Created by luckyyflv on 16-3-9.
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p/>
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p/>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
public class RangeSum {
    public int[] nums;

    public RangeSum(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {

        if (i > j || i < 0 || j > nums.length - 1)
            throw new IndexOutOfBoundsException();
        int sum = 0;

        // while(i<=j){
        //     sum+=nums[i++];


        // return sum;
        for (int index = i; index <= j; index++) {
            sum += nums[index];
        }
        return sum;


    }
}
