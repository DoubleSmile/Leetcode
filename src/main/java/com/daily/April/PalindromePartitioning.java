package com.daily.April;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckyyflv on 16-4-23.
 * <p/>
 * Given a string s, partition s such that every substring of the
 * partition is a palindrome.
 * <p/>
 * Return all possible palindrome partitioning of s.
 * <p/>
 * For example, given s = "aab",
 * Return
 * <p/>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s.equals("")) {
            res.add(new ArrayList<String>());
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i + 1)) {
                for (List<String> list : partition(s.substring(i + 1))) {
                    list.add(0, s.substring(0, i + 1));
                    res.add(list);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new PalindromePartitioning().partition("aassddssaa");
    }

}
