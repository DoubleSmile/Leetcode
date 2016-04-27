package com.daily.April;

import java.util.*;

/**
 * Created by luckyyflv on 16-4-27.
 * <p/>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right
 * , then right to left for the next level and alternate between).
 * <p/>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            val = v;
        }
    }
    //一次直接submit成功，击败了60%的人。。。。^_^
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) return list;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> single = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (flag) {
                    single.add(node.val);
                } else {
                    single.addFirst(node.val);
                }
            }
            flag = !flag;
            list.add(single);
        }

        return list;
    }
}