package com.dh.offer;

import com.dh.leetcode.common.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 剑指offer 面试题16
 *
 * 反转链表
 */
public class _16_ReserveLinkedList {

    /**
     * 思想：
     * 在从头到位的遍历过程中反转前后关系
     * 所以定义两个中间变量来缓存关系，tail初始化为null，代表尾部，同时定一个tmp来存储tail的下一个节点，用来反转关系
     * 遍历是将tmp等于tail，head赋值给tail，同时head往后走，再将tail的next赋值给tmp，完成反转
     *
     * @param head 头指针
     */
    public ListNode reserve(ListNode head) {
        ListNode tail = null;
        ListNode tmp;
        while (head != null) {
            tmp = tail;
            tail = head;
            head = head.next;
            tail.next = tmp;
        }
        return tail;
    }

    /**
     * 以下三个测试用例都通过，应该就没啥问题了
     */
    @Test
    public void testReserve() {
        Assert.assertEquals(9, reserve(ListNode.initNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})).val);
        Assert.assertEquals(9, reserve(ListNode.initNode(new int[]{9})).val);
        Assert.assertEquals(null, reserve(null));
    }
}
