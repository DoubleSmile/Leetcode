package com.daily.April;

import java.util.*;

/**
 * Created by luckyyflv on 16-4-22.
 *
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */
public class MergekSortedLists {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int v){
            val=v;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        PriorityQueue<ListNode> heap = new PriorityQueue(16,new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(0), rear = head;
        head.next = null;
        for (ListNode node : lists) {
            if (node != null)
                heap.offer(node);
        }

        while (!heap.isEmpty()) {
            ListNode p = heap.poll();
            rear.next = p;
            rear = rear.next;
            p = p.next;
            if (p != null)
                heap.offer(p);
        }
        rear.next = null;
        return head.next;
    }
}