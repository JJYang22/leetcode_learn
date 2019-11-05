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


    public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }


}

