package com.dh.leetcode.zero;

import org.junit.Test;

/**
 * 75. Sort Colors
 *
 * 红白蓝排序
 * https://leetcode.com/problems/sort-colors/
 *
 * 0 红色 1 白色 2 蓝色 给定一个数组，将他们按照红色-白色-蓝色的顺序排序
 */
public class _75_SortColors {


    /**
     * 这就是一个排序问题，不过题目中提示说不应该使用库函数
     * 如果能一次迭代完成就更好，那么就试试一次迭代
     *
     * 定一个两个指针 red从0开始，blue从末尾开始
     * 遍历时如果遇到0就上浮，red后移，遇到2就下沉，blue前移
     *
     * 当下标遇到blue时表示已经处理完毕
     * 因为可能还有进一步比较的需要，例如TestCase [2,1,2]这种情况，所以blue交换完后需要将i归位
     * 提交到第三次才成功
     *
     *
     * AC结果
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
     * Memory Usage: 34.7 MB, less than 95.68% of Java online submissions for Sort Colors.
     */
    public void sortColors(int[] nums) {
        int red = 0, blue = nums.length - 1;
        int i = 0;
        while (i <= blue) {
            switch (nums[i]) {
                case 0:
                    swap(nums, i, red);
                    red++;
                    break;
                case 2:
                    swap(nums, i, blue);
                    blue--;
                    i--;
                    break;
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }

    @Test
    public void testSortColors() {
        int[] a = new int[]{2, 1, 2};
        sortColors(a);
        System.out.println(a);
    }
}
