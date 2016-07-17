package com.daily.April;

import java.util.*;

/**
 * Created by luckyyflv on 16-4-13.
 * <p/>
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p/>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p/>
 * For example,
 * <p/>
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * <p/>
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<String>();
        Set<String> resultSet = new HashSet<String>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            if (set.contains(temp)) {
                resultSet.add(temp);
            }else{
                set.add(temp);
            }
        }
        return new ArrayList(resultSet);
    }

    public static void main(String[] args){
        RepeatedDNASequences R=new RepeatedDNASequences();
        System.out.println(R.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
