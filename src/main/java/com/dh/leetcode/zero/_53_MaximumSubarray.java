package com.dh.leetcode.zero;

import org.junit.Assert;
import org.junit.Test;

/**
 * 53. Maximum Subarray
 *
 * 剑指Offer纪念版 面试题31
 *
 * 给一个数组，求子数组的最大和
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * https://leetcode.com/problems/maximum-subarray/
 */
public class _53_MaximumSubarray {


    /**
     * 常规解法
     *
     * Runtime: 1 ms, faster than 96.21% of Java online submissions for Maximum Subarray.
     * Memory Usage: 38.3 MB, less than 92.85% of Java online submissions for Maximum Subarray.
     *
     * @return 数组
     */
    public int maxSubArray(int[] nums) {
        int fi = Integer.MIN_VALUE;
        int fi_1 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || fi_1 <= 0) {
                fi_1 = nums[i];
            } else {
                fi_1 = fi_1 + nums[i];
            }
            if (fi_1 > fi) {
                fi = fi_1;
            }
        }
        return fi;
    }

    /**
     * 分治法处理
     *
     * @param nums 数组
     */
    public int maxSubArrayDivide(int[] nums) {
        return 0;
    }

    /**
     * 动态规划解法
     *
     * dp状态方程
     *
     * f(i)=pData[i] i=0 or f(i-1)<=0
     * f(i)=f(i-1)+pData[i] i!=0 and f(i-1)>0
     *
     * @param nums 数组
     *
     * AC结果如下
     *
     * Runtime: 1 ms, faster than 96.21% of Java online submissions for Maximum Subarray.
     * Memory Usage: 38.3 MB, less than 92.85% of Java online submissions for Maximum Subarray.
     */
    public int maxSubArrayDP(int[] nums) {
        int fi = Integer.MIN_VALUE;
        int fi_1 = Integer.MIN_VALUE;

        //定义状态数组
        int[] pData = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

        }
        return fi;
    }


    /**
     * 首先来穷举法
     *
     * 穷举所有连续组合，然后求出最大值
     * 这个当然不符合题目要求
     *
     * @param nums 数组
     */
    public int maxSubArrayBrute(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    @Test
    public void testMaxSubArray() {
        Assert.assertEquals(1, maxSubArrayDP(new int[]{1, -1}));
        Assert.assertEquals(-1, maxSubArrayDP(new int[]{-1, -2, -3, -4}));
        Assert.assertEquals(1, maxSubArrayDP(new int[]{1}));
        Assert.assertEquals(6, maxSubArrayDP(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(18, maxSubArrayDP(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
    }
}
