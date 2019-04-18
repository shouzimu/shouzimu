package com.dh.leetcode.two;

import org.junit.Assert;
import org.junit.Test;

/**
 * 204. Count Primes
 *
 * https://leetcode.com/problems/count-primes/
 */
public class _204_CountPrimes {

    public int countPrimes(int n) {
        int i = 0;
        for (int j = 2; j <= n; j++) {
            if (isPrimes(j)) {
                i++;
            }
        }

        return i;
    }

    private boolean isPrimes(int n) {
        if (n == 2) {
            return false;
        }
        for (double i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCountPrimes() {
        Assert.assertEquals(0, countPrimes(2));
        Assert.assertEquals(1, countPrimes(3));
        Assert.assertEquals(4, countPrimes(10));
    }
}
