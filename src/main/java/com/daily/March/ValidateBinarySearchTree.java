package com.daily.March;

import org.omg.CORBA.INTERNAL;

import javax.jnlp.IntegrationService;

/**
 * Created by luckyyflv on 16-3-20.
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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        else if (root.left != null && root.left.val >= root.val) return false;
        else if (root.right != null && root.right.val <= root.val) return false;
        else {
            return max(root.left) < root.val && min(root.right) > root.val
                    && isValidBST(root.left) && isValidBST(root.right);
        }
    }

    public int min(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int temp = Math.min(root.val, min(root.left));
        return Math.min(temp, min(root.right));
    }

    public int max(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int temp = Math.max(root.val, max(root.left));
        return Math.max(temp, max(root.right));
    }

    public static void main(String[] arsg) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
//        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
        System.out.println(Integer.MAX_VALUE);
    }
}
