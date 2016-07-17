package com.daily.April;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckyyflv on 16-4-15.
 *
 * Given a binary tree, return the postorder traversal(后序遍历) of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].
 */
public class BinaryTreePostorderTraversal {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> list=new ArrayList<Integer>();
        postorder(root,list);
        return list;
    }

    public void postorder(TreeNode node,List list){
        if(node != null){
            postorder(node.left,list);
            postorder(node.right,list);
            list.add(node.val);
        }
    }

}
