package com.daily.February;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] array = nums1.clone();
        int index = 0;
        int i = 0;
        int j = 0;
        for (; i < m && j < n; ) {
            if (array[i] < nums2[j]) {
                nums1[index++] = array[i];
                i++;
            } else {
                nums1[index++] = nums2[j];
                j++;
            }
        }
        if (i >= m) {
            for (int k = j; k < n; k++) {
                nums1[index++] = nums2[k];
            }
        } else {
            for (int k = i; k < m; k++) {
                nums1[index++] = array[k];
            }
        }


    }
}
