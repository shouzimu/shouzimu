package com.dh.leetcode.one;

import org.junit.Assert;
import org.junit.Test;

/**
 * 198. House Robber
 *
 * https://leetcode.com/problems/house-robber/
 */
public class _198_HouseRobber {

    public int rob(int[] nums) {
        int sum1 = 0, sum2 = 0;
        int length = nums.length;
        for (int i = 0; i < length; i += 2) {
            sum1 += nums[i];
            if (i + 1 < length) {
                sum2 += nums[i + 1];
            }
        }
        return Math.max(sum1, sum2);
    }

    @Test
    public void testRob() {
        Assert.assertEquals(4, rob(new int[]{1, 2, 3, 1}));
        Assert.assertEquals(12, rob(new int[]{2, 7, 9, 3, 1}));
        Assert.assertEquals(4, rob(new int[]{2, 1, 1, 2}));
    }
}
