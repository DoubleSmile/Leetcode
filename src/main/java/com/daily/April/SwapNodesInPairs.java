package com.daily.April;

/**
 * Created by luckyyflv on 16-4-22.
 * <p/>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p/>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p/>
 * Your algorithm should use only constant space. You may not modify the values in the list,
 * only nodes itself can be changed.
 */
public class SwapNodesInPairs {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p_pre = new ListNode(1);
        p_pre.next = head;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode newHead = cur;
        while (pre != null && cur != null) {
            pre.next = cur.next;
            cur.next = pre;
            p_pre.next = cur;
            p_pre = pre;
            pre = pre.next;
            if (pre != null) {
                cur = pre.next;
            } else {
                pre = null;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swap = new SwapNodesInPairs();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next=node5;
        ListNode node = swap.swapPairs(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
