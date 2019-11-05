package Obj.Node430;

/**
 * @Author Voidmian
 * @Date 2019/11/4 18:01
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}
