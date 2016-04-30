package com.daily.April;

import java.math.BigDecimal;

/**
 * Created by luckyyflv on 16-4-30.
 * <p/>
 * Given two binary strings, return their sum (also a binary string).
 * <p/>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100"
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        /*if(a.equals("") || a.trim().length() == 0) return b;
        else if(b.equals("") || b.trim().length() == 0) return a;
        else{
            return Long.toBinaryString(Long.valueOf(a, 2) + Long.valueOf(b,2));
        }*/
        //总是没有人家的方法优雅。。。唉。。。
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("111", "1"));
    }

}