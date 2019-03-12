package com.dh.leetcode.zero;

import org.junit.Assert;
import org.junit.Test;

/**
 * 27. Remove Element
 *
 * https://leetcode.com/problems/remove-element/
 */
public class _27_RemoveElement {

    public int removeElementOld(int[] nums, int val) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int res = nums.length;

        for (int i = 0; i < nums.length; ) {
            if (nums[i] == val) {
                //删除i 后续节点都前移
                for (int j = i; j < res - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                res--;
                nums[res] = 0;
            }
            if (nums[i] != val) {
                i++;
            }
            if (i == res) {
                break;
            }
        }

        return res;
    }


    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }

        }

        return j;
    }

    @Test
    public void testRemoveElement() {
        Assert.assertEquals(2, removeElement(new int[]{3, 2, 2, 3}, 3));
        Assert.assertEquals(5, removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        Assert.assertEquals(4, removeElementOld(new int[]{4, 4, 0, 1, 0, 2}, 0));
    }
}
