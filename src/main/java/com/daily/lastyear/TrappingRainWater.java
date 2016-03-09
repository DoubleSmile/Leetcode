package com.daily.lastyear;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p/>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; ) {
            if (height[i] < 1) {
                i++;
                continue;
            }

            int nextIndex = findFirstHigherNumber(height, i);
            if (nextIndex == -1) {
                i++;
                continue;
            }

            int h = min(height[i], height[nextIndex]);

            for (int j = i + 1; j < nextIndex; j++) {
                sum = sum + h - height[j];
            }
            i = nextIndex;

        }
        return sum;
    }

    private int min(int a, int b) {
        return a >= b ? b : a;
    }

    private int findFirstHigherNumber(int[] target, int beginIndex) {
        if (beginIndex == target.length || beginIndex < 0)
            return -1;
        int height = target[beginIndex];
        for (int j = height; j > 0; j--) {
            for (int i = beginIndex + 1; i < target.length; i++) {
                if (target[i] >= j)
                    return i;
            }
        }
        return -1;
    }
}
