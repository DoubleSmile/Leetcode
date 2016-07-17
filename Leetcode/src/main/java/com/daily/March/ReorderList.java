package com.daily.March;

/**
 * Created by luckyyflv on 16-3-30.
 * <p/>
 * <p/>
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p/>
 * You must do this in-place without altering the nodes' values.
 * <p/>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseHead = slow.next;
        slow.next = null;
        reverseHead = reverse(reverseHead);
        merge(head, reverseHead);
    }

    public ListNode merge(ListNode pre, ListNode after) {
        ListNode head = pre;
        while (after != null) {
            ListNode temp = after;
            after = after.next;
            temp.next = null;
            temp.next = pre.next;
            pre.next = temp;
            pre = temp.next;
        }
        if (pre != null) {
            pre.next = after;
        }
        return head;
    }

    //递归实现链表翻转竟然直接爆栈。吓死宝宝了
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        /*else{
            ListNode  newHead=reverse(head.next);//先反转后面的链表
            head.next.next=head;//再将当前节点设置为其然来后面节点的后续节点
            head.next=null;
            return newHead;
        }*/
        ListNode p = head.next;
        ListNode q = head;
        while (p != null) {
            q.next = p.next;//记录下p的下一个节点
            p.next = head;
            head = p;
            p = q.next;//准备将p的下一个节点放到表头
        }
        return head;
    }

}
