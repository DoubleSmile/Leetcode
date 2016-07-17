package com.daily.April;

/**
 * Created by luckyyflv on 16-4-20.
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ≥ s. If there isn't one,
 * return 0 instead.
 * <p/>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {
    //这是我参考其他人的方法得来的，时间复杂度只有O(n)，最后顺利通过
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;

        int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;

        while (end < nums.length) {
            sum += nums[end];

            //optimize the array
            while (sum >= s) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    //这个方法是我本人所做，时间复杂度为O(n*n),最后由于时间太长没有通过
    /*public int minSubArrayLen(int s, int[] nums) {
        if(nums == null ||nums.length == 0)  return 0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(sum(nums,i,j) >=s){
                    min=Math.min(j+1-i,min);
                    break;
                }
            }
        }

        return min;
    }

    public int sum(int[] array,int i,int j){
        int sum=0;
        for(int index=i;i<=j;i++){
            sum+=array[index];
        }
        return sum;
    }*/

}
