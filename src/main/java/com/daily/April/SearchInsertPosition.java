package com.daily.April;

/**
 * Created by luckyyflv on 16-4-13.
 * <p/>
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p/>
 * You may assume no duplicates in the array.
 * <p/>
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int begin, int end, int target) {
        if (begin <= end) {
            int mid = (begin + end) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                if (mid < end && target < nums[mid + 1]) {
                    return mid + 1;
                }
                return binarySearch(nums, mid + 1, end, target);
            } else {
                if (mid > begin && target > nums[mid - 1]) {
                    return mid;
                }
                return binarySearch(nums, begin, mid - 1, target);
            }
        }
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        return -1;
    }

    public boolean between(int left, int right, int num) {
        return num >= left && num <= right;
    }

    public static void main(String[] args) {
        SearchInsertPosition S = new SearchInsertPosition();
        int[] array = {1, 3, 5};
        System.out.println(S.searchInsert(array, 1));

    }
}
