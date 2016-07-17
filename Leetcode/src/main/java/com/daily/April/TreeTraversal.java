package com.daily.April;

import java.util.*;

/**
 * Created by luckyyflv on 16-4-15.
 * 因为之前做过很多树的遍历操作，所以特意在这里做一个总结
 */
public class TreeTraversal {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v){
            val=v;
        }
    }

    //递归-前序遍历
    public void recursivePreorderTraversal(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            recursivePreorderTraversal(root.left);
            recursivePreorderTraversal(root.right);
        }
    }

    //递归-中序遍历
    public void recursiveInorderTraversal(TreeNode root){
        if(root != null){
            recursivePreorderTraversal(root.left);
            System.out.println(root.val);
            recursivePreorderTraversal(root.right);
        }
    }

    //递归-后序遍历
    public void recursivePostorderTraversal(TreeNode root){
        if(root != null){
            recursivePreorderTraversal(root.left);
            recursivePreorderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    //非递归-前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.add(p.val);  // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return result;
    }

    //非递归-中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                p = node.right;
            }
        }
        return result;
    }

    //非递归-后序遍历(这里借助了一种逆向思想，值得学习)
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }
}
