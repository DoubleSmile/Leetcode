package com.daily.April;

import java.util.Stack;

/**
 * Created by luckyyflv on 16-4-5.
 * <p/>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p/>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.trim().equals("")) return true;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (!stack.empty()) {
                if (match(stack.peek(), c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public boolean match(char c, char s) {
        switch (c) {
            case '(':
                return s == ')';
            case '{':
                return s == '}';
            case '[':
                return s == ']';
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("{()[}]"));
    }
}
