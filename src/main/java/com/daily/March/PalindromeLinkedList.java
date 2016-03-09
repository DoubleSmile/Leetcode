package com.daily.March;

/**
 * Created by luckyyflv on 16-3-10.
 *
 * Given a singly linked list, determine if it is a palindrome.
 */
public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {  //find middle of list.
            slow = slow.next;
            fast = fast.next.next;
        }                          //if odd, 'slow' starts with the middle, or it starts with the right half

        ListNode cur = slow.next;
        slow.next = null;          //set the tail so that we can iterate it in the very below loop

        while (cur != null) {           //reverse 'slow'
            ListNode temp = cur.next;
            cur.next = slow;
            slow = cur;
            cur = temp;
        }

        while (slow != null) {           //compare. 'head' contains all element, 'slow' only have right half part
            if (head.val != slow.val) {
                return false;
            } else {
                slow = slow.next;
                head = head.next;
            }
        }
        return true;
    }
}
