package com.daily.February;

import java.util.Arrays;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p/>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray{

        public int[] beforeProduct(int[] nums) {
            int[] result = new int[nums.length];
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 1) {
                    result[index++] = nums[i];
                }
            }
            result = Arrays.copyOfRange(result, 0, index);
            index = 0;
            for (int i = 0; i < result.length - 1; i++) {
                if (nums[i] == -1 && nums[i + 1] == -1) {
                    i++;
                    continue;
                }
                result[index++] = nums[i];
            }
            result = Arrays.copyOfRange(result, 0, index);
            return result;
        }


        public int maxProduct(int[] nums) {
            if (nums.length == 0) return 0;
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                int product = 1;
                int rowMax = nums[i];
                int neg = 0;
                int j = i;
                for (; j < nums.length; j++) {
                    if (nums[j] == 0) break;
                    product = product * nums[j];
                    if (nums[j] < 0) neg++;
                    if (neg % 2 == 0) rowMax = product;
                }
                max = Math.max(rowMax, max);
                if (neg % 2 == 0 && j == nums.length) return max;
            }
            return max;

        }

        public int product(int[] array, int beginIndex, int endIndex) {
            int result = 1;
            for (int i = beginIndex; i <= endIndex; i++) {
                result *= array[i];
            }
            return result;
        }
}
