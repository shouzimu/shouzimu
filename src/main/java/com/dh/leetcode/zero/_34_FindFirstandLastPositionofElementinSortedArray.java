package com.dh.leetcode.zero;

import org.junit.Assert;
import org.junit.Test;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 给定一个有序数组和目标值，查找第一个和最后一个出现的位置，如果找不到 return [-1, -1].
 *
 * 时间复杂度必须为 O(log n)
 */
public class _34_FindFirstandLastPositionofElementinSortedArray {

    /**
     * 时间复杂度为O(log n)所以我们应该使用二分法
     *
     * 分别查找第一个出现的位置和最后一个出现的位置
     *
     * AC结果
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in
     * Sorted Array.
     * Memory Usage: 44.1 MB, less than 5.19% of Java online submissions for Find First and Last Position of Element in
     * Sorted Array.
     *
     * 测试用例写得不到位，导致第三次才ac
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        int first = searchFirst(nums, nums.length, target);
        if (first != -1) {
            res[0] = first;
            int last = first;
            if (last < nums.length - 1) {
                last = searchLast(nums, first, target);
            }
            res[1] = last;
        }
        return res;
    }

    /**
     * 查找第一个出现的位置
     *
     * @param nums 数组
     * @param end 结束位置
     * @param value 目标值
     */
    private int searchFirst(int[] nums, int end, int value) {
        int low = 0, high = end - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > value) {
                high = mid - 1;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                //如果是第一个元素或者前一个一个下标值不等于目标值，则说明是最后一个元素
                //否则继续往前找
                if (mid == 0 || nums[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 查找最后一个出现的位置
     *
     * @param nums 数组
     * @param start fist+1作为start
     * @param value 目标值
     */
    private int searchLast(int[] nums, int start, int value) {
        int low = start, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > value) {
                high = mid - 1;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                //如果是最后一个元素或者下一个下标值不等于目标值，则说明是最后一个元素
                //否则继续往后找
                //这个地方由于复制了first方法没改mid==0，导致ac错了两次，cv大法还是要谨慎
                if (mid == nums.length - 1 || nums[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void testSearchRange() {
        Assert.assertArrayEquals(new int[]{1, 2}, searchRange(new int[]{1, 2, 2}, 2));
//        Assert.assertArrayEquals(new int[]{1, 1}, searchRange(new int[]{1, 4}, 4));
//        Assert.assertArrayEquals(new int[]{0, 0}, searchRange(new int[]{4}, 4));
//        Assert.assertArrayEquals(new int[]{3, 4}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
//        Assert.assertArrayEquals(new int[]{-1, -1}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
//        Assert.assertArrayEquals(new int[]{-1, -1}, searchRange(new int[]{}, 6));
    }

}
