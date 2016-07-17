package com.daily.February;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p/>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p/>
 * If the target is not found in the array, return [-1, -1].
 * <p/>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchforaRange {

    public int[] searchRange(int[] nums, int target) {
        int[] notFound = {-1, -1};
        if (nums.length == 0) {
            return notFound;
        } else {
            int begin = 0;
            int end = nums.length - 1;
            int mid = nums.length / 2;
            while (end >= begin) {
                if (nums[mid] > target) {
                    end = mid - 1;
                    mid = (end + begin) / 2;
                } else if (nums[mid] < target) {
                    begin = mid + 1;
                    mid = (end + begin) / 2;
                } else {
                    int beginIndex = mid;
                    int endIndex = mid;
                    for (int i = mid - 1; i >= 0; i--) {
                        if (nums[i] == target) {
                            beginIndex--;
                        } else {
                            break;
                        }
                    }
                    for (int i = mid + 1; i < nums.length; i++) {
                        if (nums[i] == target) {
                            endIndex++;
                        } else {
                            break;
                        }
                    }
                    int[] result = {beginIndex, endIndex};
                    return result;
                }
            }
        }
        return notFound;
    }
}
