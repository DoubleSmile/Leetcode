package com.daily.lastyear;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p/>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesfromSortedListII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode pre = new ListNode(0);
        ListNode node = head;
        pre.next = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                while (node.next != null && node.val == node.next.val) {
                    node.next = node.next.next;
                }
                if (node.val == head.val) {
                    head = node.next;
                }
                //这一步就是要删除node
                pre.next = node.next;

                node = node.next;

                continue;

            }

            pre = node;
            node = node.next;
        }
        return head;
    }
}
