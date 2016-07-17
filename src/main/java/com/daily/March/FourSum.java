package com.daily.March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luckyyflv on 16-3-29.
 * <p/>
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p/>
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * <p/>
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 *
 *
 * 这个方法是我从网上看到的，并不是自己所。。。。。自己能想到的就是O(n^4)或者O(n^3)的算法，并没有这么快。
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int second = 0, third = 0, nexti = 0, nextj = 0;
        //i用来控制第一个元素
        for (int i = 0, L = nums.length; i < L - 3; i++) {
            if (nums[i] << 2 > target) return list; // return immediately
            //j用来控制最后一个元素
            for (int j = L - 1; j > i + 2; j--) {
                if (nums[j] << 2 < target) break; // break immediately
                int rem = target - nums[i] - nums[j];
                int lo = i + 1, hi = j - 1;
                while (lo < hi) {
                    int sum = nums[lo] + nums[hi];
                    if (sum > rem) --hi;
                    else if (sum < rem) ++lo;
                    else {
                        list.add(Arrays.asList(nums[i], nums[lo], nums[hi], nums[j]));
                        while (++lo <= hi && nums[lo - 1] == nums[lo]) continue; // avoid duplicate results
                        while (--hi >= lo && nums[hi] == nums[hi + 1]) continue; // avoid duplicate results
                    }
                }
                while (j >= 1 && nums[j] == nums[j - 1]) --j; // skip inner loop
            }
            while (i < L - 1 && nums[i] == nums[i + 1]) ++i; // skip outer loop
        }
        return list;
    }
}
