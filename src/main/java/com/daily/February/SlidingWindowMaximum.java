package com.daily.February;

/**
 * Created by luckyyflv on 16-3-10.
 * <p/>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p/>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * <p/>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < 1) {
            int[] r = {};
            return r;
        }
        int[] result = new int[nums.length + 1 - k];
        for (int i = 0; i < result.length; i++) {
            result[i] = sum(nums, i, i + k - 1);
        }
        return result;
    }

    public int sum(int[] array, int beginIndex, int endIndex) {
        int sum = array[beginIndex];
        for (int i = beginIndex; i <= endIndex; i++) {
            sum = Math.max(sum, array[i]);
        }
        return sum;
    }
}
