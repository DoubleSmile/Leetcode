package com.daily.March;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckyyflv on 16-3-21.
 * <p/>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p/>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * /  \
 * 4    8
 * /     / \
 * 11   13   4
 * /  \     /  \
 * 7   2  5    1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p/>
 * 以下算法并非原创，是我从Discuss上看到的一个比较不错的算法，特别值得学习。巧妙地运用的递归的做法来实现。
 */
public class PathSumII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        // Store path as we decend
        List<Integer> path = new ArrayList<Integer>();
        dfs(root, 0, target, path, results);
        return results;
    }

    /**
     * Node - the current being looked at
     * sum  - the sum for the current path
     * target - the targetted total
     * path - the nodes seen in the current path
     * results - the list of paths that led to the targetted total
     */
    public void dfs(TreeNode node, int sum, int target, List<Integer> path, List<List<Integer>> results) {
        if (node == null) return;
        // Add the value of the current node to the sum
        sum += node.val;
        // Add the current node the path
        path.add(node.val);

        // If it's a leaf node and the sum matches what we're targetting
        // add the path to the list of paths that lead to the targetted total
        if (node.left == null && node.right == null && sum == target) {
            results.add(new ArrayList(path));
            return;
        }

        // Visit recursivelly the left branch, but only if it exists :)
        if (node.left != null) {
            dfs(node.left, sum, target, path, results);
            // Remove the last node from the path since we're going to explore other paths when
            // we return the function
            path.remove(path.size() - 1);
        }

        // Same as above, but now for the right branch
        if (node.right != null) {
            dfs(node.right, sum, target, path, results);
            path.remove(path.size() - 1);
        }
    }

}
