package com.daily.February;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p/>
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        } else {
            if (head.val == val) {
                return removeElements(head.next, val);
            } else {
                ListNode node = head;
                while (node.next != null) {
                    if (node.next.val == val) {
                        if (node.next.next == null) {//如果是尾节点
                            node.next = null;
                            return head;
                        } else {
                            node.next = node.next.next;
                        }
                    }
                    //node=node.next;
                    else {
                        node = node.next;
                    }
                }
                return head;
            }
        }
    }
}

