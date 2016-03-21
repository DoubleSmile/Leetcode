package com.daily.March;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckyyflv on 16-3-21.
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v){
            val=v;
        }
    }
    boolean result=false;
    public boolean hasPathSum(TreeNode root, int sum) {
        List<Integer> path=new ArrayList<Integer>();
        dfs(root,0,sum,path);
        return result;
    }
    public void dfs(TreeNode node, int sum, int target, List<Integer> path) {
        if (node == null) return;
        sum += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && sum == target) {
            result=true;
            return;
        }
        if (node.left != null) {
            dfs(node.left, sum, target, path);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            dfs(node.right, sum, target, path);
            path.remove(path.size() - 1);
        }
    }
}
