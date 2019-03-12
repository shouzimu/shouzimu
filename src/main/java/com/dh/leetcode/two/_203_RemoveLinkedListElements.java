package com.dh.leetcode.two;

import com.dh.leetcode.common.ListNode;
import org.junit.Test;

/**
 * 203. Remove Linked List Elements
 *
 * https://leetcode.com/problems/remove-linked-list-elements/
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 *
 * Output: 1->2->3->4->5
 */
public class _203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(-1);
        ListNode curr = head, pre = temp;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = pre.next;
            }
            curr = curr.next;
        }
        return temp.next;
    }

    @Test
    public void testRemoveElements() {
        ListNode node = ListNode.initNode(new int[]{6, 2, 6, 3, 4, 5, 6});
        node = removeElements(node, 6);

        node.print();
    }


}
