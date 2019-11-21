package DataStructure.Obj.NaryTreeNode;

import java.util.List;

/**
 * @Author Voidmian
 * @Date 2019/11/19 10:22
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
