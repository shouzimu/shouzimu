package com.dh.leetcode.two;

import org.junit.Test;

/**
 * 283. Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/
 *
 * 将数组中的0移动到末尾，同时其余数字的顺序需要保持
 */
public class _283_MoveZeroes {

    /**
     *
     * 这个题和第27题
     * @see com.dh.leetcode.zero._27_RemoveElement
     * 处理逻辑一致
     *
     * 使用快慢下标 i,j i每次后移一位，j初始为0，当遇到i下标不为0的时候，将i下标的值付给j下标的值，同时j++
     * 以此达到类似去除0的数后数组前移动的功能
     *
     * AC 结果
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Move Zeroes.
     * Memory Usage: 39.3 MB, less than 70.84% of Java online submissions for Move Zeroes.
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    @Test
    public void testMoveZeroes() {
        int[] nums = new int[]{1, 0, 0, 0, 2, 3, 4, 5, 0, 0};
        moveZeroes(nums);
        System.out.println();
    }

}
