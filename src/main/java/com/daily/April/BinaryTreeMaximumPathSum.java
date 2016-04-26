package com.daily.April;

/**
 * Created by luckyyflv on 16-4-26.
 * <p/>
 * Given a binary tree, find the maximum path sum.
 * <p/>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path does not need to go through the root.
 * <p/>
 * For example:
 * Given the below binary tree,
 * <p/>
 * 1
 * / \
 * 2   3
 * Return 6.
 * <p/>
 * <p/>
 * 不得不感叹的是你绞尽脑汁去想的问题被人家几句代码就搞定了
 * 基本上感觉只要出现树的地方差不多都可以用递归解决
 */
public class BinaryTreeMaximumPathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            val = v;
        }
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    // helper returns the max branch
    // plus current node's value
    int helper(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
    }

}
