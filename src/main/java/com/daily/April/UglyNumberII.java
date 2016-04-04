package com.daily.April;

/**
 * Created by luckyyflv on 16-4-3.
 * <p/>
 * Write a program to find the n-th ugly number.
 * <p/>
 * Ugly numbers are positive numbers whose prime factors
 * only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the
 * sequence of the first 10 ugly numbers.
 * <p/>
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumberII {
    //这是我从网上看到的最简单的方法，运用了DP
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1]; // dp[i] holds the ith's ugly number
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) { // loop invariant:dp[i] holds the smallest ith uglynumber
            dp[i] = Math.min(2 * dp[p2], Math.min(3 * dp[p3], 5 * dp[p5])); // the next ugly number must be built from a smaller ugly number
            if (dp[i] == 2 * dp[p2]) p2++;
            if (dp[i] == 3 * dp[p3]) p3++;
            if (dp[i] == 5 * dp[p5]) p5++;
        }
        return dp[n];
    }

    //这是自己所做的方法，相比以上方法，显得是很low
    public int nthUglyNumberComp(int n) {
        if (n < 1) {
            return -1;
        } else if (n == 1) {
            return 1;
        } else {
            int count = 1;
            for (int i = 2; ; i++) {
                if (isUgly(i)) {
                    count++;
                    if (count == n) {
                        return i;
                    }
                }
            }
        }
    }

    public boolean isUgly(int n) {
        int maxFactor = 1;
        for (int i = n / 2; i >= 2; i--) {
            if (n % i == 0 && isPrime(i)) {
                maxFactor = i;
                break;
            }
        }
        if (isPrime(n) && n > 5) {
            return false;
        } else return maxFactor > 5 ? false : true;
    }

    public Boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        UglyNumberII ugly = new UglyNumberII();
        System.out.println(ugly.nthUglyNumber(165));
        /*for(int i=1;i<20;i++){
            System.out.println(ugly.nthUglyNumber(i));
        }*/
    }

}
