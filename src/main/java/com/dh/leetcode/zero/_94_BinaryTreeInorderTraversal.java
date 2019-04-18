package com.dh.leetcode.zero;

import com.dh.leetcode.common.TreeNode;
import com.dh.leetcode.common.TreeNodeIterator;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * 94. Binary Tree Inorder Traversal
 *
 * 二叉树中序非递归输出
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class _94_BinaryTreeInorderTraversal {


    /**
     * 非递归方式中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }


    /**
     *
     * 第一次写法使用的递归，但是题目说可不可以使用非递归写法
     * AC结果
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 36.1 MB, less than 59.04% of Java online submissions for Binary Tree Inorder Traversal.
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalOld(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (null == node) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

    @Test
    public void TestInorderTraversal() {
        TreeNode root = TreeNodeIterator.initTestTree(new Integer[]{1, null, 2, 3});
        List<Integer> res = inorderTraversal(root);
        System.out.println(res.size());
    }
}
