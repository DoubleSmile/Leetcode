package com.daily.May;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by luckyyflv on 16-5-8.
 * One way to serialize a binary tree is to use pre-order traversal.
 * When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as #.
 * <p/>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string
 * "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * <p/>
 * Given a string of comma separated values, verify whether it is a correct
 * preorder traversal serialization of a binary tree. Find an algorithm
 * without reconstructing the tree.
 * <p/>
 * Each comma separated value in the string must be either an integer or a
 * character '#' representing null pointer.
 * <p/>
 * You may assume that the input format is always valid, for example it could
 * never contain two consecutive commas such as "1,,3".
 * <p/>
 * Example 1:
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 * <p/>
 * Example 2:
 * "1,#"
 * Return false
 * <p/>
 * Example 3:
 * "9,#,#,1"
 * Return false
 */
public class VerifyPreorderSerializationOfABinaryTree {
    /*public boolean isValidSerialization(String preorder) {
        if (preorder.equals("") || preorder.trim().length() == 0) return false;
        String[] nums = preorder.split(",");
        Stack<String> stack = new Stack<String>();
        for (int i=0;i<nums.length;i++) {
            if (!stack.empty()) {
                String s = stack.peek();
                if (s.equals("#") && nums[i].equals("#")) {
                    stack.pop();
                    if(stack.empty()) return false;
                    stack.pop();
                    if(!stack.empty() && stack.peek().equals("#")) {
                        stack.pop();
                        stack.pop();
                        if(!stack.empty()){
                            stack.pop();
                            if(!stack.empty()) stack.pop();
                        }
                    }
                    continue;
                }
                stack.add(nums[i]);
            }else{
                stack.add(nums[i]);
            }
        }
        return stack.empty();
    }*/

    //废了九牛二虎之力没做成却被人家几句代码搞定，膜拜！！！
    public boolean isValid(String preorder) {
        String[] strs = preorder.split(",");
        int degree = -1;         // root has no indegree, for compensate init with -1
        for (String str : strs) {
            degree++;             // all nodes have 1 indegree (root compensated)
            if (degree > 0) {     // total degree should never exceeds 0
                return false;
            }
            if (!str.equals("#")) {// only non-leaf node has 2 outdegree
                degree -= 2;
            }
        }
        return degree == 0;
    }

}