package com.daily.February;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by luckyyflv on 16-3-10.
 * <p/>
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
public class ContainsDuplicateIII {
    class Pair {
        int val;
        int index;

        Pair(int v, int i) {
            this.val = v;
            this.index = i;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || t < 0 || k < 1) {
            return false;
        }
        int len = nums.length;
        Pair[] pair = new Pair[len];
        for (int i = 0; i < len; i++) {
            pair[i] = new Pair(nums[i], i);
        }

        Arrays.sort(pair, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.val - p2.val;
            }
        });

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len && Math.abs((long) pair[j].val - (long) pair[i].val) <= (long) t; j++) {
                int indexDiff = Math.abs(pair[i].index - pair[j].index);
                if (indexDiff <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
