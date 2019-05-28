package com.dh.leetcode.zero;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * 46. Permutations
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class _46_Permutations {


    /**
     * 回溯法
     * 全排列共N!种组合方式，我们可以预先初始化好list，减少扩容带来的性能损耗
     *
     * AC结果
     * 执行用时 : 4 ms, 在Permutations的Java提交中击败了74.90% 的用户
     * 内存消耗 : 38.9 MB, 在Permutations的Java提交中击败了53.32% 的用户
     *
     * @param nums 输入数组
     */
    List<List<Integer>> res = new ArrayList<>(1);

    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        if (null == nums || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        visited = new boolean[nums.length];
        res = new ArrayList<>(factorialA(nums.length));
        helper(nums, 0, new ArrayList<>());
        return res;
    }


    private void helper(int[] a, int currentIndex, List<Integer> premute) {
        if (premute.size() == a.length) {
            res.add(new ArrayList<>(premute));
            return;
        }

        for (int j = 0; j < a.length; j++) {
            if (visited[j]) {
                continue;
            }
            visited[j] = true;
            premute.add(a[j]);
            helper(a, currentIndex + 1, premute);
            premute.remove(premute.size() - 1);
            visited[j] = false;

        }
    }


    private int factorialA(int n) {
        if (n == 0) {
            return 0;
        }
        int t = 1;
        for (int i = 1; i <= n; i++) {
            t *= i;
        }
        return t;
    }

    @Test
    public void testPermute() {
        Assert.assertEquals(6, permute(new int[]{1, 2, 3, 4}).size());
    }

}
