package com.dh.leetcode.two;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * 217 Contains Duplicate
 *
 * https://leetcode.com/problems/contains-duplicate/
 *
 * 给定一个整数数组，查找数组是否包含任何重复项。
 *
 * 如果数组中任何值至少出现两次，则函数应返回true，如果每个元素都不相同，则返回false。
 *
 * 例1：
 *
 * 输入： [1,2,3,1] 输出： true 例2：
 *
 * 输入： [1,2,3,4] 输出： false
 */
public class _217_ContainsDuplicate {


    /**
     * 这个题目第一想到的方法就是先排序，这样相同的就会相邻 然后遍历判断是否相等即可得重复
     *
     * 方法2：使用HashSet的add元素，如果存在重复则add返回false也可得出答案
     *
     * AC结果
     *
     * Runtime: 5 ms, faster than 94.95% of Java online submissions for Contains Duplicate.
     *
     * Memory Usage: 40.2 MB, less than 91.69% of Java online submissions for Contains Duplicate.
     */
    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);
        boolean res = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                res = true;
                break;
            }

        }
        return res;
    }

    @Test
    public void testContainsDuplicate() {
        Assert.assertEquals(true, containsDuplicate(new int[]{1, 2, 3, 1}));
        Assert.assertEquals(false, containsDuplicate(new int[]{1, 2, 3, 4}));
        Assert.assertEquals(true, containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }


}
