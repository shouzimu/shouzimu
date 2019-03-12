package com.dh.leetcode.one;

import org.junit.Assert;
import org.junit.Test;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 */
public class _121_BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {

        int max = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;

    }

    @Test
    public void testMaxProfit() {
        Assert.assertEquals(5, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

}
