package DataStructure.MyQueue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/10/30 14:19
 */
public class MyQueueByStack {
    static public void test(){
        MyQueueByStack stack=new MyQueueByStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        stack.push(4);



    }

    Stack <Integer> stack;

    /** Initialize your data structure here. */
    public MyQueueByStack() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        int [] temp =new int[stack.size()];
        for (int i=0;i<temp.length;i++) {
            temp[i]=stack.pop();
        }
        stack.push(x);
        for (int i = temp.length-1; i >=0 ; i--) {
            stack.push(temp[i]);
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
