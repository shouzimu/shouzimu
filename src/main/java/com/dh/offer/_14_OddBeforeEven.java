package com.dh.offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * 剑指offer面试题14
 *
 * 调整数组顺序是奇数位于偶数的前面
 */
public class _14_OddBeforeEven {

    /**
     * 暴力法
     *
     * 从前往后遍历，遇到偶数就放到末尾，后面的数依次往后移
     */
    public int[] oddBeforeEvenBrute(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //偶数，后移
            if (nums[i] % 2 == 0) {
                int j = i;
                int temp = nums[i];
                for (; j < length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[j] = temp;
                length--;
            }
            if (nums[i] % 2 == 0) {
                i--;
            }
        }
        return nums;
    }

    /**
     * 指针法
     */
    public int[] oddBeforeEvenPoint(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[right] % 2 == 0) {
                right--;
            }
            if (nums[left] % 2 == 0) {
                int t = nums[right];
                nums[right] = nums[left];
                nums[left] = t;
                left++;
                right--;
            } else {
                left++;
            }
        }
        return nums;
    }

    @Test
    public void testOffBeforeEven() {

        Assert.assertArrayEquals(new int[]{}, oddBeforeEvenBrute(new int[]{}));

        Assert.assertArrayEquals(new int[]{2, 2, 2, 2, 2},
                oddBeforeEvenBrute(new int[]{2, 2, 2, 2, 2}));

        Assert.assertArrayEquals(new int[]{1, 1, 2, 2, 2, 2},
                oddBeforeEvenBrute(new int[]{2, 2, 2, 2, 1, 1}));

        Assert.assertArrayEquals(new int[]{1, 3, 5, 7, 8, 6, 4, 2},
                oddBeforeEvenBrute(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));

        Assert.assertArrayEquals(new int[]{}, oddBeforeEvenPoint(new int[]{}));

        Assert.assertArrayEquals(new int[]{2, 2, 2, 2, 2},
                oddBeforeEvenPoint(new int[]{2, 2, 2, 2, 2}));

        Assert.assertArrayEquals(new int[]{1, 1, 2, 2, 2, 2},
                oddBeforeEvenPoint(new int[]{2, 2, 2, 2, 1, 1}));

        Assert.assertArrayEquals(new int[]{1, 7, 3, 5, 4, 6, 2, 8},
                oddBeforeEvenPoint(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));


    }
}
