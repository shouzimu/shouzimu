package com.dh.leetcode.one;

import org.junit.Assert;
import org.junit.Test;

/**
 * 189. Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/
 */
public class _189_RotateArray {

    /**
     * 这题还是比较简单的
     *
     * 解法 O(n*k)
     * 排名也是相当靠后
     *
     * 在继续优化到O(n)解法
     *
     * AC结果
     * Runtime: 92 ms, faster than 13.40% of Java online submissions for Rotate Array.
     * Memory Usage: 36.9 MB, less than 66.67% of Java online submissions for Rotate Array.
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        while (k > 0) {
            int a = nums[length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = a;
            k--;
        }
    }

    @Test
    public void testRoatate() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] b = {5, 6, 7, 1, 2, 3, 4};
        rotate(a, 3);
        Assert.assertArrayEquals(a, b);

        a = new int[]{-1, -100, 3, 99};
        b = new int[]{3, 99, -1, -100};
        rotate(a, 2);

        Assert.assertArrayEquals(a, b);


        a = new int[]{-1, -100, 3, 99};
        b = new int[]{-1, -100, 3, 99};
        rotate(a, 0);

        Assert.assertArrayEquals(a, b);


        a = new int[]{-1};
        b = new int[]{-1};
        rotate(a, 0);

        Assert.assertArrayEquals(a, b);



        a = new int[]{};
        b = new int[]{};
        rotate(a, 0);

        Assert.assertArrayEquals(a, b);


    }

}
