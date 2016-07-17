package com.daily.March;

/**
 * Created by luckyyflv on 16-3-10.
 * <p/>
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListtoBinarySearchTree {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode root;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        int[] array = ListToArray(head);
        root = new TreeNode(array[(array.length - 1) / 2]);
        root = findMiddleTreeNode(array, 0, array.length - 1, root);
        return root;
    }

    public TreeNode findMiddleTreeNode(int[] array, int begin, int end, TreeNode node) {
        if (begin == end - 1) {
            TreeNode tempNode = new TreeNode(array[begin]);
            tempNode.right = new TreeNode(array[end]);
            return tempNode;
        }
        if (begin < end) {
            int mid = (begin + end) / 2;
            TreeNode midNode = new TreeNode(array[mid]);
            midNode.left = findMiddleTreeNode(array, begin, mid - 1, midNode.left);
            midNode.right = findMiddleTreeNode(array, mid + 1, end, midNode.right);
            return midNode;
        }
        return new TreeNode(array[begin]);
    }

    public int[] ListToArray(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        int[] array = new int[length];
        node = head;
        for (int i = 0; i < length; i++) {
            array[i] = node.val;
            node = node.next;
        }
        return array;
    }
}
