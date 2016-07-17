package com.daily.April;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by luckyyflv on 16-4-18.
 * <p/>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p/>
 * Assume a BST is defined as follows:
 * <p/>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            val = v;
        }
    }
    //其实验证排序二叉树就是中序遍历之后节点值递增就行，但是这里我采用的是非递归写法，递归比较简单。
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.empty() || node != null) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                TreeNode temp = stack.pop();
                list.add(temp.val);
                node = temp.right;
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) <= list.get(i)) return false;
        }

        return true;
    }
}
