package com.daily.February;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p/>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;

        for (int num : nums) {
            if (res == num) ++count;
            else --count;

            if (count == 0) {
                res = num;
                count = 1;
            }
        }

        return res;
    }
}
