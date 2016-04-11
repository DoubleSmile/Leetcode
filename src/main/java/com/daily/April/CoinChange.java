package com.daily.April;

/**
 * Created by luckyyflv on 16-4-11.
 * <p/>
 * You are given coins of different denominations and a total amount
 * of money amount. Write a function to compute the fewest number of
 * coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * <p/>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p/>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int n = amount + 1;
        for (int coin : coins) {
            int curr = 0;
            if (amount >= coin) {
                int next = coinChange(coins, amount - coin);
                if (next >= 0)
                    curr = 1 + next;
            }
            if (curr > 0)
                n = Math.min(n, curr);
        }
        int finalCount = (n == amount + 1) ? -1 : n;
        return finalCount;
    }

}
