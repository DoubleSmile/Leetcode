package com.daily.April;

import java.util.Stack;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p/>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p/>
 * --------------------------------------------------------------------
 * The core idea is: Starting from the last element of the postorder and inorder array,
 * we put elements from postorder array to a stack and each one is the right child of
 * the last one until an element in postorder array is equal to the element on the
 * inorder array. Then, we pop as many as elements we can from the stack and decrease
 * the mark in inorder array until the peek() element is not equal to the mark value or
 * the stack is empty. Then, the new element that we are gonna scan from postorder array
 * is the left child of the last element we have popped out from the stack.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            val = v;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int ip = inorder.length - 1;
        int pp = postorder.length - 1;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp--;

        while (pp >= 0) {
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip--;
            }
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) {
                prev.left = newNode;
            } else if (!stack.isEmpty()) {
                TreeNode currTop = stack.peek();
                currTop.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            pp--;
        }
        return root;
    }
}
