package com.daily.July;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hzlvyanfeng on 2016/7/17.
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersInEachNode {

    static class TreeLinkNode{
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        int val;
        public TreeLinkNode(int v){
            val=v;
        }
    }

    public  void connect(TreeLinkNode root) {
        if(root == null ) return;
        Queue<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();
        queue.add(root);
        int size=0;
        while(!queue.isEmpty()){
            size=queue.size();
            TreeLinkNode head=null;
            if(size > 0){
                head=queue.poll();
                size--;
                if(head.left != null){
                    queue.add(head.left);
                }
                if(head.right !=null){
                    queue.add(head.right);
                }
            }
            while(size > 0){
                TreeLinkNode tail=queue.poll();
                size--;
                if(tail.left != null){
                    queue.add(tail.left);
                }
                if(tail.right !=null){
                    queue.add(tail.right);
                }
                head.next = tail;
                head=tail;
            }
            if(head !=null){
                head.next = null;
            }
        }
    }

    //晚上其他人写的递归方法
    public void connect_1(TreeLinkNode root) {
        if(root == null)
            return;

        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
        }

        connect_1(root.left);
        connect_1(root.right);
    }

    /*public static void main(String[] args){
        TreeLinkNode root0=new TreeLinkNode(0);
        TreeLinkNode root1=new TreeLinkNode(1);
        TreeLinkNode root2=new TreeLinkNode(2);
        TreeLinkNode root3=new TreeLinkNode(3);
        TreeLinkNode root4=new TreeLinkNode(4);
        TreeLinkNode root5=new TreeLinkNode(5);
        TreeLinkNode root6=new TreeLinkNode(6);
        root0.left=root1;
        root1.left=root3;
        root1.right=root4;
        root0.right=root2;
        root2.left=root5;
        root2.right=root6;

    }*/


}
