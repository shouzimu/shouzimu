package com.dh.leetcode.two;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

/**
 * 260. Single Number III
 *
 * https://leetcode.com/problems/single-number-iii/
 *
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear
 * exactly twice. Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5] Output: [3,5]
 */
public class _260_SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();
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
                list.add(integer);
            }
        }

        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    @Test
    public void testSingleNumber() {
        Assert.assertEquals(4, singleNumber(new int[]{1,2,1,3,2,5}));
        Assert.assertEquals(1, singleNumber(new int[]{2, 2, 1}));
    }
}
