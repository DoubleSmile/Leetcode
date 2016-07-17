package com.daily.February;

import java.util.Arrays;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p/>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        else if (s.trim().equals(t.trim())) return true;
        else {
            if (s.length() != t.length()) return false;
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            Arrays.sort(ss);
            Arrays.sort(tt);
            for (int i = 0; i < ss.length; i++) {
                if (ss[i] != tt[i])
                    return false;
            }
            return true;
        }
    }
}
