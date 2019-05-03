package com.dh.leetcode.zero;

import org.junit.Assert;
import org.junit.Test;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * 给定一个排好序的数组，移除重复的元素，返回最后的数组长度
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class _26_RemoveDuplicatesFromSortedArray {

    /**
     * @see com.dh.leetcode.two._283_MoveZeroes
     * 解决思路和283题类似，我们可以使用一快一慢两个指针来处理
     *
     * 快指针 i从0开始，慢指针从1开始，遇到 a[i]!=a[j] j++ i++,否则只i++，最后的i+1即为调整完的数组长度
     *
     * 一功submit了4次才最后成功
     * Runtime: 1 ms, faster than 99.97% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 40.9 MB, less than 83.62% of Java online submissions for Remove Duplicates from Sorted Array.
     *
     * ac结果如下
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0, j = 1;

        for (; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    @Test
    public void testRemoveDuplicates() {
        Assert.assertEquals(5, removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        Assert.assertEquals(2, removeDuplicates(new int[]{-1, 0, 0, 0}));
        Assert.assertEquals(1, removeDuplicates(new int[]{0}));
        Assert.assertEquals(0, removeDuplicates(new int[]{}));
    }


    public int removeDuplicatesError(int[] nums) {
        int length = nums.length;
        int newLength = length;
        int remove = 0;
        if (length > 1) {
            for (int i = 0; i < newLength - 1; i++) {
                while (nums[i] == nums[i + 1] && newLength - remove > 1) {
                    remove += revomeIndex(i, nums);
                    newLength--;
                }
            }
        }
        return length - remove;
    }

    int revomeIndex(int index, int[] nums) {
        int length = nums.length;
        for (int j = index; j < length - 1; j++) {
            int t = nums[j];
            nums[j] = nums[j + 1];
            nums[j + 1] = t;
        }
        nums[length - 1] = 0;
        return 1;
    }
}
