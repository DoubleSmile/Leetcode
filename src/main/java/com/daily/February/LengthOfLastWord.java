package com.daily.February;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p/>
 * If the last word does not exist, return 0.
 * <p/>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p/>
 * For example,
 * Given s = "Hello World",
 * return 5.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        s = s.replaceAll("\\s+$", "");
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != 32) {
                sum++;
                continue;
            }
            break;
        }
        return sum;
    }
}
