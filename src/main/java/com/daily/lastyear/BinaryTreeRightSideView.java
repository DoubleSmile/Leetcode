package com.daily.lastyear;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by luckyyflv on 16-3-9.
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p/>
 * For example:
 * Given the following binary tree,
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        Queue<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        List<Integer> result = new ArrayList<Integer>();
        while (!list.isEmpty()) {
            int width = list.size();
            TreeNode node = null;
            for (int i = width; i > 0; i--) {
                node = list.poll();
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            result.add(node.val);
        }
        return result;
    }
}
