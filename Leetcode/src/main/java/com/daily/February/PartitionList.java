package com.daily.February;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p/>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p/>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode p1 = l1, p2 = l2;

        p1.next = head;
        while (p1.next != null) {
            // keep moving larger node to list 2;

            if (p1.next.val >= x) {
                ListNode tmp = p1.next;
                p1.next = tmp.next;

                p2.next = tmp;
                p2 = p2.next;
            } else {
                p1 = p1.next;
            }
        }

        // conbine lists 1 and 2;
        p2.next = null;
        p1.next = l2.next;
        return l1.next;
    }
}
