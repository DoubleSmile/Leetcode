package com.daily.March;

import java.util.List;

/**
 * Created by luckyyflv on 16-3-10.
 * <p/>
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p/>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        int n = triangle.size();
        int[] dp = new int[n];
        int[] pre_dp = new int[n];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            //交换dp与pre_dp数组
            int[] tmp = pre_dp;
            pre_dp = dp;
            dp = tmp;
            for (int j = 0; j < i + 1; j++) {
                int val = triangle.get(i).get(j);
                //如果是首元素
                if (j == 0)
                    dp[j] = val + pre_dp[j];
                    //如果是尾元素
                else if (j == i)
                    dp[j] = val + pre_dp[j - 1];
                else
                    dp[j] = Math.min(val + pre_dp[j - 1], val + pre_dp[j]);
            }
        }

        int min = dp[0];
        for (int i = 1; i < dp.length; i++)
            if (dp[i] < min)
                min = dp[i];
        return min;
    }
}
