package com.daily.May;

import java.util.*;

/**
 * Created by luckyyflv on 16-5-8.
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p/>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 */
public class TopKFrequentElements {
    //当然也可以使用优先级队列来做，其实原理都一样
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return list;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.get(num) != null) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<Map.Entry<Integer, Integer>>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            entries.add(entry);
        }

        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return 1;
                } else if (o1.getValue() < o2.getValue()) {
                    return -1;
                }
                return 0;
            }
        });

        for (int i = 0; i < k; i++) {
            list.add(entries.get(i).getKey());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {-1, -1};
        new TopKFrequentElements().topKFrequent(array, 1);
    }
}