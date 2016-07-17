package com.daily.March;

/**
 * Created by luckyyflv on 16-3-12.
 * <p/>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p/>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {

    static int LENGTH = 16;
    int[] array = new int[LENGTH];
    int capacity = 0;

    public boolean needInc() {
        if (capacity >= LENGTH * 0.75) {
            LENGTH = LENGTH << 1;
            return true;
        }
        return false;
    }

    public void inc() {
        int[] newArray = new int[LENGTH];
        System.arraycopy(array, 0, newArray, 0, capacity);
        array = newArray;
    }

    public void push(int x) {
        if (needInc()) {
            inc();
        }
        array[capacity++] = x;
    }

    public void pop() {
        if (capacity > 0) {
            capacity--;
            array[capacity] = Integer.MAX_VALUE;
        }
    }

    public int top() {
        if (capacity > 0) {
            return array[capacity - 1];
        } else {
            return -1;
        }
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < capacity; i++) {
            min = Math.min(array[i], min);
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);

        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
