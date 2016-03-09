package com.daily.March;

/**
 * Created by luckyyflv on 16-3-10.
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                ListNode temp = node.next.next;
                node.next.next = null;
                node.next = temp;
                continue;
            }
            node = node.next;
        }
        return head;
    }
}
