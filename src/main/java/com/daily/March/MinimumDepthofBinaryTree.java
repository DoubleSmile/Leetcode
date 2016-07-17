    package com.daily.March;

    /**
     * Created by luckyyflv on 16-3-10.
     * <p/>
     * Given a binary tree, find its minimum depth.
     * <p/>
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     */
    public class MinimumDepthofBinaryTree {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null || root.right == null) return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
