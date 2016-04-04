package com.daily.April;

import java.util.*;

/**
 * Created by luckyyflv on 16-4-4.
 * <p/>
 * Given an array of strings, group anagrams together.
 * <p/>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p/>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * For the return value, each inner list's elements must follow the lexicographic order.
 * All inputs will be in lower-case.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.equals("")) return new ArrayList();
        Arrays.sort(strs);
        List<String> content = new ArrayList<String>(strs.length);
        Map<String, List> map = new HashMap<String, List>(strs.length);
        for (String s : strs) {
            String newWord = newOrder(s);
            if (!content.contains(newWord)) {
                content.add(newWord);
                List<String> single = new ArrayList<String>();
                single.add(s);
                map.put(newWord, single);
            } else {
                List choosenList = map.get(newOrder(s));
                choosenList.add(s);
            }
        }
        List<List<String>> list = new ArrayList<List<String>>();
        for (Map.Entry<String, List> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    public String newOrder(String word) {
        char[] array = word.toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);
    }

}
