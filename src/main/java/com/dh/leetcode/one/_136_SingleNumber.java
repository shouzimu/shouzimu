package com.dh.leetcode.one;

import java.util.HashMap;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

/**
 * 136. Single Number
 *
 * https://leetcode.com/problems/single-number/
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Input: [2,2,1] Output: 1
 */
public class _136_SingleNumber {

    /**
     * 这个能最先想到的方式就是 使用一个HashMap存储出现的次数，然后遍历map找出出现一次的
     *
     * leetcode测试的时候遇到一个编译问题，说是找不到Entry,所以换成keySet的方式遍历
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            Integer v = map.get(num);
            if (v == null) {
                v = 0;
            }
            map.put(num, v + 1);
        }
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            if (map.get(integer) == 1) {
                return integer;
            }
        }

        return 0;
    }

    @Test
    public void testSingleNumber() {
        Assert.assertEquals(4, singleNumber(new int[]{4, 1, 2, 1, 2}));
        Assert.assertEquals(1, singleNumber(new int[]{2, 2, 1}));
    }
}
