package com.daily.February;

/**
 * Created by luckyyflv on 16-3-10.
 * <p/>
 * Given a binary tree, find its maximum depth.
 * <p/>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthofBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        int leftDepth = 0;
        int rightDepth = 0;
       /* if(root.left!=null || root.right!=null){
            depth++;
        }*/
        if (root.left != null) {
            leftDepth = maxDepth(root.left);
        }
        if (root.right != null) {
            rightDepth = maxDepth(root.right);
        }
        depth += Math.max(leftDepth, rightDepth);
        return depth;
    }
}
