package com.dh.leetcode.five;

import com.dh.leetcode.common.TreeNode;
import com.dh.leetcode.common.TreeNodeIterator;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * 剑指offer面试题18
 *
 *
 * 572. Subtree of Another Tree
 *
 * 另一个树的子树
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 树s
 *      3
 *     / \
 *   4   5
 *  / \
 * 1   2
 *
 * 树t
 *  4
 * / \
 * 1   2
 *
 * 则t是s的子树
 *
 * 如果树s是
 *
 *         3
 *       / \
 *     4   5
 *    / \
 *   1   2
 *        \
 *         0
 *
 * 则t不是s的子树，因为2还有个右子节点0，返回false
 * 我第一次提交就是在这个地方吃了个亏，产生了错误答案
 */
public class _572_SubtreeOfAnotherTree {


    /**
     * 运行结果
     *
     * 执行用时 : 18 ms, 在Subtree of Another Tree的Java提交中击败了54.80% 的用户
     * 内存消耗 : 42.5 MB, 在Subtree of Another Tree的Java提交中击败了72.37% 的用户
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean result = checkIsSubTree(s, t);
        if (!result && null != s) {
            result = isSubtree(s.left, t);
        }
        if (!result && null != s) {
            result = isSubtree(s.right, t);
        }
        return result;
    }


    private boolean checkIsSubTree(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return checkIsSubTree(s.left, t.left) && checkIsSubTree(s.right, t.right);
    }

    @Test
    public void checkIsSubTree() {
        TreeNode s = TreeNodeIterator.initTestTree(new Integer[]{null});
        TreeNode t = TreeNodeIterator.initTestTree(new Integer[]{1});
        Assert.assertEquals(false, isSubtree(s, t));

        s = TreeNodeIterator.initTestTree(new Integer[]{3, 4, 5, 1, 2});
        t = TreeNodeIterator.initTestTree(new Integer[]{4, 1, 2});
        Assert.assertEquals(true, isSubtree(s, t));

        s = TreeNodeIterator.initTestTree(new Integer[]{null});
        t = TreeNodeIterator.initTestTree(new Integer[]{null});
        Assert.assertEquals(true, isSubtree(s, t));

        s = TreeNodeIterator.initTestTree(new Integer[]{1});
        t = TreeNodeIterator.initTestTree(new Integer[]{1});
        Assert.assertEquals(true, isSubtree(s, t));

        s = TreeNodeIterator.initTestTree(new Integer[]{3, 4, 5, 1, 2});
        t = TreeNodeIterator.initTestTree(new Integer[]{1, 2});
        Assert.assertEquals(false, isSubtree(s, t));

        s = TreeNodeIterator.initTestTree(new Integer[]{3, 4, 5, 1, 2, null, null, 0});
        t = TreeNodeIterator.initTestTree(new Integer[]{4, 1, 2});
        Assert.assertEquals(false, isSubtree(s, t));
    }
}
