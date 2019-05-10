package com.dh.offer;

import com.dh.leetcode.common.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 剑指offer 面试题15
 *
 * 链表中倒数第k个节点
 */
public class _15_FindKthToTail {

    /**
     * 假设链表有n个节点，那么倒数第k个节点就是 n-k+1个，我们从前只需要往后走n-k+1步就可以了
     * 但是链表的长度我们是不知道的
     * 定义两个指针，第一个指针从前往后走k-1步，这时候第二个指针在同时和第一个指针往后走，由于2个
     * 指针始终保持k-1的距离，所以当第一个指针走到末尾时，第二个指针刚好到 倒数 k 的节点
     *
     * @param head 头指针
     * @param k 数字
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (null == head || k < 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }

        if (k > 0) {
            return null;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    @Test
    public void testFindKthToTail() {
        ListNode head = ListNode.initNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        Assert.assertEquals(8, findKthToTail(head, 3).val);
        Assert.assertEquals(null, findKthToTail(head, 0));
        Assert.assertEquals(null, findKthToTail(head, 11));
    }

}
