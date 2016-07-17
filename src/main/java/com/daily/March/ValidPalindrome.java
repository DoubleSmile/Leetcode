package com.daily.March;

/**
 * Created by luckyyflv on 16-3-15.
 * <p/>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p/>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i <= j; ) {
            while (i <= j && !valid(s.charAt(i))) {
                i++;
            }
            while (i <= j && !valid(s.charAt(j))) {
                j--;
            }
            if (i <= j) {
                if(s.charAt(i)==s.charAt(j)){
                    i++;
                    j--;
                    continue;
                }else if(Character.isLetter(s.charAt(i)) && Character.isLetter(s.charAt(j))
                            && Math.abs(s.charAt(i)-s.charAt(j))== 32){
                    i++;
                    j--;
                    continue;
                } else {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean valid(char a) {
        if (Character.isLetterOrDigit(a)) return true;
        return false;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        ValidPalindrome pa = new ValidPalindrome();
        System.out.println(pa.isPalindrome(s1));
        System.out.println(pa.isPalindrome("0"));
    }
}
