package com.dh.leetcode.one;

import com.dh.leetcode.common.TreeNode;
import com.dh.leetcode.common.TreeNodeIterator;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * 101. Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/
 *
 * 判断一棵树是否对称
 */
public class _101_SymmetricTree {

    public boolean isSymmetricV2(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        leftRootRight(root, left);
        rightRootLeft(root, right);
        boolean res = true;
        if (left.size() != right.size()) {
            res = false;
        } else {
            for (int i = 0; i < left.size(); i++) {
                Integer v1 = left.get(i);
                Integer v2 = right.get(i);
                if (null != v1 && null != v2) {
                    if (v1 != v2) {
                        res = false;
                        break;
                    }

                } else if (null != v1 && null == v2) {
                    res = false;
                    break;
                } else if (null == v1 && null != v2) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    public void leftRootRight(TreeNode node, List<Integer> list) {
        if (null == node) {
            list.add(null);
            return;
        }
        leftRootRight(node.left, list);
        list.add(node.val);
        leftRootRight(node.right, list);
    }


    public void rightRootLeft(TreeNode node, List<Integer> list) {
        if (null == node) {
            list.add(null);
            return;
        }
        rightRootLeft(node.right, list);
        list.add(node.val);
        rightRootLeft(node.left, list);
    }


    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && (isSymmetric(node1.right, node2.left)) && (isSymmetric(node1.left,
                node2.right));
    }

    @Test
    public void testisSymmetric() {
        Assert.assertEquals(true, isSymmetric(TreeNodeIterator.initTestTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        Assert.assertEquals(false,
                isSymmetric(TreeNodeIterator.initTestTree(new Integer[]{1, 2, 2, null, 3, null, 3})));
        Assert.assertEquals(false,
                isSymmetric(TreeNodeIterator.initTestTree(new Integer[]{1, 2, 3, 3, null, 2, null})));
    }
}
