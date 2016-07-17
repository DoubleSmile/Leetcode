package com.daily.lastyear;

import java.util.ArrayList;

/**
 * Created by luckyyflv on 16-3-9.
 * <p/>
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p/>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p/>
 * Find the total sum of all root-to-leaf numbers.
 * <p/>
 * For example,
 * <p/>
 * 1
 * / \
 * 2   3
 * <p/>
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p/>
 * Return the sum = 12 + 13 = 25.
 */
public class SumRoottoLeafNumbers {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private ArrayList<ArrayList<TreeNode>> allRoute = new ArrayList<ArrayList<TreeNode>>();

    public void traceRoute(TreeNode node, ArrayList route) {
        if (node == null)
            return;
        route.add(node);
        if (node.left == null && node.right == null) {
            allRoute.add(route);
        } else {
            traceRoute(node.left, (ArrayList<TreeNode>) route.clone());
            traceRoute(node.right, (ArrayList<TreeNode>) route.clone());
        }

    }

    public int getNumber(ArrayList<TreeNode> route) {
        StringBuilder sb = new StringBuilder();
        for (TreeNode node : route) {
            sb.append(node.val);
        }
        return Integer.parseInt(sb.toString());
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        traceRoute(root, new ArrayList());
        int sum = 0;
        for (ArrayList route : allRoute) {
            sum += getNumber(route);
        }
        return sum;

    }

}
