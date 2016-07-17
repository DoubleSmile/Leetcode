package com.daily.April;

import java.util.Stack;

/**
 * Created by luckyyflv on 16-4-25.
 * <p/>
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p/>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
public class SimplePath {

    public String simplifyPath(String path) {
        if (path.equals("") || path == null || path.trim().length() == 0 || path.equals("/")) return "/";
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals(".") || paths[i].equals("")) continue;
            else if (paths[i].equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                    stack.pop();
                }
            } else {
                stack.push("/");
                stack.push(paths[i]);
            }
        }

        if (stack.empty()) return "/";
        String[] strs = new String[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            strs[i] = stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SimplePath Path = new SimplePath();
        System.out.println(Path.simplifyPath("/."));
    }

}

