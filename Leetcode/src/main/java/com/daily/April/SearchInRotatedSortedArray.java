package com.daily.April;

/**
 * Created by luckyyflv on 16-4-30.
 * <p/>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p/>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p/>
 * You are given a target value to search. If found in the array return its index,
 * otherwise return -1.
 * <p/>
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
    public int binarySearch(int[] array, int begin, int end, int target) {
        if (begin <= end) {
            int mid = (begin + end) / 2;
            if (target < array[mid]) {
                return binarySearch(array, begin, mid - 1, target);
            } else if (target > array[mid]) {
                return binarySearch(array, mid + 1, end, target);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int mid = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                mid = i;
                break;
            }
        }
        if (mid == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        int index_1 = binarySearch(nums, 0, mid, target);
        if (index_1 != -1) {
            return index_1;
        }
        int index_2 = binarySearch(nums, mid + 1, nums.length - 1, target);
        if (index_2 != -1) {
            return index_2;
        }

        return -1;
    }
}