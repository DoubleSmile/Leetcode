package com.daily.March;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckyyflv on 16-3-28.
 * <p/>
 * Given a collection of distinct numbers, return all possible permutations.
 * <p/>
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) throws Exception {
        if (nums == null || nums.length < 1) return null;
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> single = new ArrayList<Integer>();
        single.add(nums[0]);
        all.add(single);
        ArrayList<ArrayList<Integer>> list = all;
        for (int i = 1; i < nums.length; i++) {
            list = permute(nums[i], list);
        }
        return (List) list;
    }

    public ArrayList<ArrayList<Integer>> permute(int num, ArrayList<ArrayList<Integer>> list) throws Exception {
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> singleList : list) {
            for (int i = 0; i <= singleList.size(); i++) {
                ArrayList<Integer> temp = (ArrayList<Integer>) singleList.clone();
                temp.add(i, num);
                all.add(temp);
            }
        }
        return all;
    }
}
