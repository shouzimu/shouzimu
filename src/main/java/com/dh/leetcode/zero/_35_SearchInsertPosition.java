package com.dh.leetcode.zero;

import org.junit.Assert;
import org.junit.Test;

/**
 * 35. 搜索插入位置
 *
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 */
public class _35_SearchInsertPosition {

    /**
     * 有序数组，首先想到的是二分查找
     *
     * 首先按照等于的逻辑二分查找数字，找到则返回对应下标
     * 如果没有找到则继续二分找第一个大于目标值的数的下标
     *
     * AC结果
     * 执行用时 : 1 ms, 在Search Insert Position的Java提交中击败了97.25% 的用户
     * 内存消耗 : 37.9 MB, 在Search Insert Position的Java提交中击败了81.06% 的用户
     */
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0 || nums[0] > target) {
            return 0;
        } else if (nums[length - 1] < target) {
            return length;
        }

        int find = binarySearch(nums, target);
        if (find == -1) {
            find = binarySearchGreater(nums, target);
        }
        return find;
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找第一个大于等于target的数字
     */
    private int binarySearchGreater(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void testSearchInsert() {
        Assert.assertEquals(1, searchInsert(new int[]{1, 3}, 3));
        Assert.assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
        Assert.assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
        Assert.assertEquals(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
        Assert.assertEquals(0, searchInsert(new int[]{1, 3, 5, 6}, 0));
        Assert.assertEquals(0, searchInsert(new int[]{1, 3, 5, 6, 9, 10, 12}, 0));
    }
}
