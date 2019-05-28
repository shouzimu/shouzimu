package com.dh.leetcode.zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * 39. Combination Sum
 *
 * 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 */
public class _39_CombinationSum {

    /**
     * 回溯法
     *
     *
     * AC结果
     * 执行用时 : 6 ms, 在Combination Sum的Java提交中击败了96.95% 的用户
     * 内存消耗 : 38.9 MB, 在Combination Sum的Java提交中击败了87.92% 的用户
     *
     * @param candidates 数组
     * @param target 目标值
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (null == candidates) {
            return list;
        }
        Arrays.sort(candidates);
        sum(candidates, new ArrayList<>(), 0, target, list);
        return list;
    }

    private void sum(int[] candidates, List<Integer> list, int index, int target, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            list.add(candidates[i]);
            sum(candidates, list, i, target - candidates[i], res);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void testCombinationSum() {
        List<List<Integer>> list = combinationSum(new int[]{2, 3, 5}, 8);
    }
}
