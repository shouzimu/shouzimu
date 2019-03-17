package com.dh.leetcode.two;

import com.dh.leetcode.common.ListNode;
import org.junit.Test;

/**
 * 237. Delete Node in a Linked List
 *
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class _237_DeleteNodeinaLinkedList {


    /**
     * 这个题比较无语，删除传入的这个节点
     *
     * 写的第一版以为有head指针，妥妥的编译报错
     *
     * 所以只有一个节点的情况下要删除第一时间想到的是将prev的next指向node的next，
     * 如果没有head怎么找到prev，很显然这条路走不通
     * 这个时候我们可以把next的值复制给node就可以了
     *
     * 例如 1->2->3->4 删除 3，我们把4的节点信息
     *
     * 而且题目还限制了不可能是尾部且是有效的节点
     *
     *
     * AC结果
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
     * Memory Usage: 37.5 MB, less than 57.39% of Java online submissions for Delete Node in a Linked List.
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

        /*
        ListNode next = node.next;
        if (next != null) {
            node.val = next.val;
            node.next = next.next;
        } else {
            node = next;
        }*/

    }

    @Test
    public void testDeleteNode() {

    }


    /*
    public void deleteNode(ListNode node) {
        ListNode tmp = new ListNode(-1);
        ListNode curr = this, pre = tmp;
        while (curr != null) {
            if (curr.val == node.val) {
                pre.next = curr.next;
            } else {
                pre = pre.next;
            }
            curr = curr.next;
        }

    }
    */
}
