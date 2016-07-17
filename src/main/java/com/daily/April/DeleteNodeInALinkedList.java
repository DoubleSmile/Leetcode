package com.daily.April;

/**
 * Created by luckyyflv on 16-4-28.
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p/>
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 *
 * 此题无趣
 */
public class DeleteNodeInALinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
        }
    }

    public void deleteNode(ListNode node) {
        ListNode nxtNode = node.next;
        node.val = nxtNode.val;
        node.next = nxtNode.next;
    }

}
