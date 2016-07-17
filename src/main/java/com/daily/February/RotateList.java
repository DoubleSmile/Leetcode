package com.daily.February;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p/>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        ListNode temp = head;
        int length = 1;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        ListNode tail = head;
        int left = length - k;
        while (left < 0) {
            left += length;
        }
        if (left == 0) {
            return temp;
        }

        head = temp;
        left--;
        while (left != 0) {
            head = head.next;
            left--;
        }
        ListNode newHead = head.next;
        head.next = null;
        tail.next = temp;
        return newHead;

    }
}
