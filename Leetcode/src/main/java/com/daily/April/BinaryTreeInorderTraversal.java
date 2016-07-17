package com.daily.April;

import java.util.*;

/**
 * Created by luckyyflv on 16-4-18.
 * <p/>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p/>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 */
public class BinaryTreeInorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root == null) return list;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node=root;
        while(!stack.empty() || node != null){
            //说明没有走到叶子节点末尾
            if(node != null){
                stack.add(node);
                node=node.left;
            }else{
                node=stack.pop();
                list.add(node.val);
                node=node.right;
            }
        }

        return list;
    }
}
