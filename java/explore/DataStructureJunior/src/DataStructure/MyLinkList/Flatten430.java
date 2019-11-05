package DataStructure.MyLinkList;

import Obj.Node430.Node;

import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/11/4 18:02
 */


public class Flatten430 {
    static public void test() {
        Flatten430 flatten430 = new Flatten430();
    }

    public Node flatten(Node head) {
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur.child != null) {
                if(cur.next != null)
                    stack.push(cur.next);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
            if (cur.next == null && !stack.isEmpty()) {
                cur.next = stack.pop();
                cur.next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
