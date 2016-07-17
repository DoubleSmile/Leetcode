package com.daily.March;

import java.util.Stack;

/**
 * Created by luckyyflv on 16-3-14.
 *
 * Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.
 */

public class ImplementQueueUsingStacks {
    Stack<Integer> stack_asc = new Stack<Integer>();
    Stack<Integer> stack_desc = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack_asc.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!stack_asc.isEmpty()){
            stack_desc.clear();
            while(stack_asc.size() > 0){
                stack_desc.add(stack_asc.pop());
            }

            stack_desc.pop();

            if(!stack_desc.isEmpty()){
                stack_asc.clear();

                while(stack_desc.size() > 0){
                    stack_asc.add(stack_desc.pop());
                }
            }

        }
    }

    // Get the front element.
    public int peek() {
        int result=-1;
        if(!stack_asc.isEmpty()){
            stack_desc.clear();
            while(stack_asc.size() > 0){
                stack_desc.add(stack_asc.pop());
            }

            result=stack_desc.peek();

            if(!stack_desc.isEmpty()){
                stack_asc.clear();

                while(stack_desc.size() > 0){
                    stack_asc.add(stack_desc.pop());
                }
            }
        }
        return result;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack_asc.isEmpty();
    }

    public static void main(String[] arsg){
        ImplementQueueUsingStacks queue=new ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.pop();
        queue.push(4);
        System.out.println(queue.peek());
        System.out.println(queue.empty());
    }
}
