package com.daily.February;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by luckyyflv on 16-3-9.
 */
public class ImplementStackusingQueues {

    class MyStack {
        ArrayBlockingQueue<Integer> left = new ArrayBlockingQueue<Integer>(16);
        ArrayBlockingQueue<Integer> right = new ArrayBlockingQueue<Integer>(16);
        int temp = 0;
        int height = 0;

        // Push element x onto stack.
        public void push(int x) {
            if (left.size() > 0) {
                left.add(x);
                height++;
            } else {
                right.add(x);
                height++;
            }
        }

        // Removes the element on top of the stack.
        public void pop() {
            if (left.size() > 0) {
                for (int i = 0; i < height - 1; i++) {
                    temp = left.poll();
                    right.add(temp);
                }
                height--;
                left.clear();
            } else if (right.size() > 0) {
                for (int i = 0; i < height - 1; i++) {
                    temp = right.poll();
                    left.add(temp);
                }
                height--;
                right.clear();
            } else {

            }
        }

        // Get the top element.
        public int top() {
            if (left.size() > 0) {
                for (int i = 0; i < height; i++) {
                    temp = left.poll();
                    right.add(temp);
                }
                return temp;
            } else if (right.size() > 0) {
                for (int i = 0; i < height; i++) {
                    temp = right.poll();
                    left.add(temp);
                }
                return temp;
            } else {
                return -1;
            }
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return left.size() == 0 && right.size() == 0;
        }
    }
}