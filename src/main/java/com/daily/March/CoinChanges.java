package com.daily.March;

/**
 * Created by luckyyflv on 16-3-10.
 * <p/>
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p/>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p/>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 */
public class CoinChanges {
    public int coinChange(int[] coins, int amount) {
        int min = Integer.MAX_VALUE;
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        for (int i = 0; i < coins.length; i++) {
            int temp = coinChange(coins, amount - coins[i]);
            if (temp != -1 && temp < min) {
                min = temp;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min + 1;
    }
}
