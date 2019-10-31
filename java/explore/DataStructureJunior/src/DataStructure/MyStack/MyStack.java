package DataStructure.MyStack;

import DataStructure.MyQueue.MyQueueByStack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Voidmian
 * @Date 2019/10/30 14:58
 */
public class MyStack {
    static public void test(){
        MyStack stack =new MyStack();
    }

    List<Integer> stack ;
    /** Initialize your data structure here. */
    public MyStack() {
        stack=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int ans=stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return ans;
    }

    /** Get the top element. */
    public int top() {
        return stack.get(stack.size()-1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.size() == 0;
    }
}
