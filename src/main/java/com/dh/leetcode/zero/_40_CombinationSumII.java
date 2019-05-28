package com.dh.leetcode.zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * 40. Combination Sum II
 *
 * 组合总和 II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 *
 * @see _39_CombinationSum 和这个题目的区别就是数字仅允许出现一次
 */
public class _40_CombinationSumII {


    /**
     * AC结果
     *
     * 执行用时 : 19 ms, 在Combination Sum II的Java提交中击败了57.94% 的用户
     * 内存消耗 : 38.2 MB, 在Combination Sum II的Java提交中击败了84.98% 的用户
     *
     * 这个去重逻辑写的比较屎了~
     * 等再优化
     *
     * @param candidates 输入
     * @param target 目标值
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == candidates || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        //小于开头的数，直接返回
        if (target < candidates[0]) {
            return res;
        }
        sum(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    /**
     * 使用Arrays的containAll遇到一个坑[1,1,2,2]和[2,2,2]它返回了true
     *
     * @param candidates 数组
     * @param target 目标值
     * @param currentIndex 当前下标
     * @param res 结果
     * @param sum 组合数组
     */
    private void sum(int[] candidates, int target, int currentIndex, List<List<Integer>> res, List<Integer> sum) {
        if (target == 0) {
            List<Integer> a = new ArrayList<>(sum);
            boolean exist = false;
            for (List<Integer> re : res) {
                if (re.size() == a.size()) {
                    int k = 0;
                    for (; k < a.size(); k++) {
                        if (a.get(k) != re.get(k)) {
                            break;
                        }
                    }
                    if (k == a.size()) {
                        exist = true;
                        break;
                    }
                }
            }
            if (!exist) {
                res.add(a);
            }
            return;
        }
        for (int i = currentIndex; i < candidates.length && target >= candidates[i]; i++) {
            sum.add(candidates[i]);
            sum(candidates, target - candidates[i], i + 1, res, sum);
            sum.remove(sum.size() - 1);

        }

    }

    @Test
    public void testCombinationSum2() {
        Assert.assertEquals(5, combinationSum2(new int[]{4, 4, 2, 1, 4, 2, 2, 1, 3}, 6).size());
        Assert.assertEquals(2, combinationSum2(new int[]{2, 5, 2, 1, 2}, 5).size());
        Assert.assertEquals(4, combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8).size());
        Assert.assertEquals(1, combinationSum2(new int[]{2, 3, 5}, 8).size());
    }
}
