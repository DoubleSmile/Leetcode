package com.daily.March;

/**
 * Created by luckyyflv on 16-3-13.
 * <p/>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p/>
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * <p/>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 */
public class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
    }

    void update(int i, int val) {
        if(i < 0 || i >nums.length-1) return;
        nums[i]=val;
    }

    public int sumRange(int i, int j) {
        if(i < 0 || j >nums.length-1) return -1;
        int sum=0;
        for(int index=i;i<=j;i++){
            sum+=nums[index];
        }
        return sum;
    }
}