package com.daily.February;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p/>
 * For example, this binary tree is symmetric:
 * <p/>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isLegal(root.left, root.right);

    }

    public boolean isLegal(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            if (left.val != right.val)
                return false;
            boolean l = isLegal(left.left, right.right);
            boolean r = isLegal(left.right, right.left);
            return (l && r);
        }
        return false;
    }
}
