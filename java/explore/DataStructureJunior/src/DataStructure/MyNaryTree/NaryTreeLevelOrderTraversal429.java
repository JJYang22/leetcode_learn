package DataStructure.MyNaryTree;

import DataStructure.Obj.NaryTreeNode.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Voidmian
 * @Date 2019/11/19 10:42
 */
public class NaryTreeLevelOrderTraversal429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ans.add(new ArrayList<>());
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Node cur = queue.poll();
                ans.get(ans.size() - 1).add(cur.val);
                for (Node n : cur.children) {
                    queue.add(n);
                }
            }
        }
        return ans;
    }
}
