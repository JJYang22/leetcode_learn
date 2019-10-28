package Obj;

import java.util.List;

/**
 * @Author Voidmian
 * @Date 2019/10/28 14:23
 */

public class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

    public void setVal(int val) {
        this.val = val;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }


}

