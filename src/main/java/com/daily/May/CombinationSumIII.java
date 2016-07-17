package com.daily.May;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckyyflv on 16-5-2.
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination
 * should be a unique set of numbers.
 * <p/>
 * Ensure that numbers within the set are sorted in ascending order.
 * <p/>
 * Example 1:
 * <p/>
 * Input: k = 3, n = 7
 * <p/>
 * Output:
 * <p/>
 * [[1,2,4]]
 * <p/>
 * Example 2:
 * <p/>
 * Input: k = 3, n = 9
 * <p/>
 * Output:
 * <p/>
 * [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combine(k, n, 1);
    }

    public List<List<Integer>> combine(int k, int n, int begin) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (k < 1) return list;
        if (k == 1 && n >= 1 && n <= 9 && n >= begin) {
            List<Integer> single = new ArrayList<Integer>();
            single.add(n);
            list.add(single);
        } else {
            for (int i = begin; i < (n + 1) / k; i++) {
                for (List<Integer> l : combine(k - 1, n - i, i + 1)) {
                    l.add(0, i);
                    list.add(l);
                }
            }
        }
        return list;
    }
}
