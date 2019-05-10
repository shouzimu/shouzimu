package com.dh.leetcode.one;

import org.junit.Assert;
import org.junit.Test;

/**
 * 162. Find Peak Element
 *
 * 找出峰值元素
 *
 * 峰值元素就是比它邻居大的元素
 *
 * https://leetcode.com/problems/find-peak-element/
 *
 * nums[-1] = nums[n] = -∞.
 */
public class _162_FindPeakElement {

    /**
     * @param nums 输入数组
     *
     * AC结果
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
     * Memory Usage: 37.1 MB, less than 90.09% of Java online submissions for Find Peak Element.
     */
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int index = -1;
        boolean morePre;
        boolean moreAfter;
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                moreAfter = true;
            } else {
                moreAfter = nums[i] > nums[i + 1];
            }

            if (i == 0) {
                morePre = true;
            } else {
                morePre = nums[i] > nums[i - 1];
            }

            if (moreAfter && morePre) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Test
    public void testFindPeakElement() {
        Assert.assertEquals(0, findPeakElement(new int[]{Integer.MIN_VALUE}));
        Assert.assertEquals(1, findPeakElement(new int[]{Integer.MIN_VALUE, 1}));
        Assert.assertEquals(0, findPeakElement(new int[]{1, 0, 1, 3, 5, 6, 4}));
        Assert.assertEquals(2, findPeakElement(new int[]{1, 2, 3, 1}));
        Assert.assertEquals(0, findPeakElement(new int[]{1}));
        Assert.assertEquals(5, findPeakElement(new int[]{1, 2, 3, 4, 5, 6}));
    }

}
