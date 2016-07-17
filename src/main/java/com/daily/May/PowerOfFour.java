package com.daily.May;

/**
 * Created by luckyyflv on 16-5-11.
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

    Example:
    Given num = 16, return true. Given num = 5, return false.
 */
public class PowerOfFour {
    //应该没有更简单的方法了吧。
    //1. num > 0 就不用过多介绍了吧
    //2. 因为4的N次幂的所有比特位上只有一个1所以使用num&(num-1）来判断是否只有一个 1
    //3. 因为1的位置只能在1，3，5.。。这些奇数位置上面，所以一个与操作就可以完成了。
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
}
