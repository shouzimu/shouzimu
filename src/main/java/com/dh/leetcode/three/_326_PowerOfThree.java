package com.dh.leetcode.three;

import org.junit.Assert;
import org.junit.Test;

/**
 * 326. Power of Three
 * <p>
 * https://leetcode.com/problems/power-of-three/
 * 给定一个整数，写一个函数来确定它是否为3的幂。
 */
public class _326_PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int total = 1;
        while (total < n) {
            total = total * 3;

            if (total == n) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testIsPowerOfThree() {
        Assert.assertEquals(true, isPowerOfThree(1));
        Assert.assertEquals(false, isPowerOfThree(2));
        Assert.assertEquals(false, isPowerOfThree(0));
        Assert.assertEquals(true, isPowerOfThree(27));
        Assert.assertEquals(false, isPowerOfThree(45));
        Assert.assertEquals(true, isPowerOfThree(81));
    }
}
