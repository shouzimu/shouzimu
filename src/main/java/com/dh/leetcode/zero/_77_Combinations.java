package com.dh.leetcode.zero;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * 77. Combinations
 *
 * https://leetcode-cn.com/problems/combinations/
 *
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class _77_Combinations {

    /**
     * 还是使用经典的回溯法
     *
     * AC结果
     * 执行用时 : 73 ms, 在Combinations的Java提交中击败了36.84% 的用户
     * 内存消耗 : 50.6 MB, 在Combinations的Java提交中击败了45.77% 的用户
     *
     * @param n 1~n
     * @param k 数字数
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k < 1) {
            return res;
        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        helper(a, k, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] a, int k, int currentIndex, List<Integer> combin, List<List<Integer>> res) {
        if (combin.size() == k) {
            res.add(new ArrayList<>(combin));
            return;
        }

        for (int j = currentIndex; j < a.length; j++) {
            combin.add(a[j]);
            helper(a, k, j + 1, combin, res);
            combin.remove(combin.size() - 1);
        }

    }

    @Test
    public void testCombine() {
        Assert.assertEquals(6, combine(4, 2).size());
    }

}
