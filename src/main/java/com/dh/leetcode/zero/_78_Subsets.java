package com.dh.leetcode.zero;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * 78. Subsets
 *
 * 给定一个元素不重复的数组，返回所有的子集
 *
 * https://leetcode.com/problems/subsets/
 */
public class _78_Subsets {

    /**
     * 位处理法 将数组从0~length看成是一串二进制的每一位，1表示包含，0表示不包含，则长度为4的范围为
     * 从0000~1111，共2^n次方种组合
     *
     * 一开始没想到这个方法，给大佬们献出膝盖
     *
     * AC结果
     * Runtime: 1 ms, faster than 79.63% of Java online submissions for Subsets.
     * Memory Usage: 38.3 MB, less than 13.00% of Java online submissions for Subsets.
     */
    public List<List<Integer>> subsets(int[] nums) {
        int numLength = nums.length;
        int length = (int) Math.pow(2, numLength);
        //直接设置list的size，减少因为为扩容带来的性能损失
        List<List<Integer>> res = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            //判断二进制第几位为1，则对应位数为数组下标
            List<Integer> integers = new ArrayList<>();
            int k = numLength - 1;
            while (k >= 0) {
                //判断一个数组第n位是否为1的方法
                //右移n-1位，将待确定位数和1做与运算，如果为1则说明该位位1，否则位0
                if (((i >> k) & 1) == 1) {
                    integers.add(nums[numLength - k - 1]);
                }
                k--;
            }
            res.add(integers);

        }
        return res;
    }


    @Test
    public void testSubSets() {
        subsets(new int[]{});
        int[] a = {5, 4, 3, 2, 1};
        System.out.println(a);
    }


}
