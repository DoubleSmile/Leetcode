package com.daily.April;

/**
 * Created by luckyyflv on 16-4-15.
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 * <p/>
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
public class SingleNumber {
    //这是我见到的最牛逼的方法，如果是自己做的话很想借助一下数据结构HashSet,但是这样估计比较慢
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }

    /*public static void main(String[] args){
        int num=100;
        System.out.println(num ^ 100 ^10 ^10);
    }*/
}
