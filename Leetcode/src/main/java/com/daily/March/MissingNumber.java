package com.daily.March;

import java.util.Arrays;

/**
 * Created by luckyyflv on 16-3-11.
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int end=nums.length-1;
        int start=0;
        while(end >= start){
            int mid=(end+start)/2;
            if(mid < nums[mid]) end=mid-1;
            else start=mid+1;
        }
        return end;
    }

}
