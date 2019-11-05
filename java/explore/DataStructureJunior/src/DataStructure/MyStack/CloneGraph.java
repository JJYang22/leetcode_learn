package DataStructure.MyStack;

import Obj.Node;

import java.util.*;

/**
 * @Author Voidmian
 * @Date 2019/10/28 14:21
 */
public class CloneGraph {
    static public void test() {

        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();


        List<Node> list1 = new ArrayList<>();
        list1.add(node2);
        list1.add(node4);


        List<Node> list2 = new ArrayList<>();
        list2.add(node3);
        list2.add(node1);

        List<Node> list3 = new ArrayList<>();
        list3.add(node4);
        list3.add(node2);

        List<Node> list4 = new ArrayList<>();
        list4.add(node1);
        list4.add(node3);

//        node1.setVal(1);
//        node2.setVal(2);
//        node4.setVal(4);
//        node3.setVal(3);
//
//
//        node1.setNeighbors(list1);
//        node2.setNeighbors(list2);
//        node3.setNeighbors(list3);
//        node4.setNeighbors(list4);

        CloneGraph cloneGraph = new CloneGraph();
        Node ans = cloneGraph.cloneGraph(node1);
        System.out.println(1);
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap();
        Node ans = fun(node, map);
        return ans;
    }

    public Node fun(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        List<Node> neighbors = new ArrayList<>();
        Node ans = new Node(node.val, neighbors);
        map.put(ans.val, ans);
        for (int i = 0; i < node.neighbors.size(); i++) {
            ans.neighbors.add(fun(node.neighbors.get(i), map));
        }
        return ans;
    }
}
