package MyStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Voidmian
 * @Date 2019/10/26 20:06
 */
public class MinStack {

    static public void test() {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }


    List<Integer> data;
    List<Integer> min;

    /**
     * initialize your data structure here.
     */


    public MinStack() {
        data = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        data.add(x);
        if (min.isEmpty())
            min.add(x);
        else {
            if (x <= min.get(min.size() - 1)) {
                min.add(x);
            }
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            if (data.get(data.size() - 1) == getMin())
                min.remove(min.size() - 1);
            data.remove(data.size() - 1);
        }
    }


    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */