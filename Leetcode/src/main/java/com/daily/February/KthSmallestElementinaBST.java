package com.daily.February;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 */
public class KthSmallestElementinaBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;
        List<TreeNode> all = new ArrayList<TreeNode>();
        treeToList(root, all);
        if (k > all.size())
            return -1;
        return all.get(k - 1).val;
    }

    public void treeToList(TreeNode node, List all) {
        if (node != null) {
            treeToList(node.left, all);
            all.add(node);
            treeToList(node.right, all);
        }
    }
}
