package com.daily.April;

import sun.java2d.pipe.AATextRenderer;

/**
 * Created by luckyyflv on 16-4-26.
 * <p/>
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p/>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p/>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null || s.equals("") || s.trim().length() == 0) return s;
        if (s.length() == 1) return s;
        char[] array = s.toCharArray();
        int i = 0, j = array.length - 1;
        while (i <= j) {
            if (!isVowels(array[i])) {
                i++;
                continue;
            }
            if (!isVowels(array[j])) {
                j--;
                continue;
            }
            swap(array, i, j);
            i++;
            j--;
        }

        return new String(array);
    }

    public void swap(char[] array, int i, int j) {
        if (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public boolean isVowels(char c) {
        char cc = Character.toLowerCase(c);
        return cc == 'a' || cc == 'e' || cc == 'i'
                || cc == 'o' || cc == 'u';
    }


    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfAString().reverseVowels("hello"));
    }
}
