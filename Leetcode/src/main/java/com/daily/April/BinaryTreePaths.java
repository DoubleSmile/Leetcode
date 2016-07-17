package com.daily.April;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckyyflv on 16-4-18.
 * <p/>
 * Given a binary tree, return all root-to-leaf paths.
 * <p/>
 * For example, given the following binary tree:
 * <p/>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * <p/>
 * ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            val = v;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if (root == null) return list;
        if (root.left == null && root.right == null) {
            list.add("" + root.val);
            return list;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left != null) {
            list = appendToPaths(root.left, new StringBuilder(sb), list);
        }
        if (root.right != null) {
            list = appendToPaths(root.right, new StringBuilder(sb), list);
        }

        return list;
    }

    public List appendToPaths(TreeNode node, StringBuilder sb, List<String> list) {
        if (node != null) {
            sb.append("->");
            sb.append(node.val);
            if (node.left == null && node.right == null) list.add(sb.toString());
            appendToPaths(node.left, new StringBuilder(sb), list);
            appendToPaths(node.right, new StringBuilder(sb), list);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        BinaryTreePaths Tree = new BinaryTreePaths();
        Tree.binaryTreePaths(root);
    }
}
