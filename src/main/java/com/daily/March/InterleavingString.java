package com.daily.March;

/**
 * Created by luckyyflv on 16-3-10.
 * <p/>
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p/>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * <p/>
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null && s3 == null) return true;
        if (s1 == null && s2 != null && s2.equals(s3)) return true;
        if (s1 != null && s1.equals(s3) && s2 == null) return true;
        if (s3 == null && (s1 != null || s2 != null)) return false;
        int insertIndex = 0;
        int length = s1.length();
        StringBuilder sb = new StringBuilder(s1);
        for (int i = 0; i <= length; i++) {
            for (int j = insertIndex; j < s2.length(); j++) {
                if (s3.startsWith(sb.insert(i, s2.charAt(i)).toString())) {
                    sb = sb.insert(i, s2.charAt(j));
                    length++;
                    i--;
                    insertIndex = j + 1;
                    break;
                }
            }
        }
        return sb.toString().equals(s3);
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
