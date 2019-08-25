package com.dh.leetcode.zero;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * @date 2019-08-26 00:36
 *
 * 88. Merge Sorted Array
 * 88. 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class _88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m < 0 || n < 0) {
            return;
        }
        //取nums1的前m个和nums2的前n个
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    @Test
    public void testMege() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {-1, 2, 5, 6};
        merge(nums1, 3, nums2, 3);
        int[] res = {-1, 1, 2, 2, 3, 5};
        Assert.assertArrayEquals(nums1, res);
    }
}
