package com.daily.May;

/**
 * Created by luckyyflv on 16-5-2.
 * <p/>
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
    //这种方式简单有效,找到回文的中心部分然后依次向左右展开，因为回文分为aba和abba型，所以分两种情况就可以
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
                start = left + 1;
                end = right - 1;
            }
            left = i;
            right = i + 1;
            while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
                start = left + 1;
                end = right - 1;
            }

        }
        return s.substring(start, end + 1);
    }
}
