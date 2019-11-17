package DataStructure.MyTree;

import DataStructure.Obj.BinaryTreeNodeHasNextRightNode.Node;
import DataStructure.Obj.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Voidmian
 * @Date 2019/11/11 19:20
 */
public class PopulatingNextRightPointersInEachNodeII117 {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            for (int i = 0; i < length-1; i++) {
                Node cur = queue.poll();
                cur.next=queue.peek();
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
            }
            Node cur = queue.poll();
            if(cur.left != null)
                queue.offer(cur.left);
            if(cur.right != null)
                queue.offer(cur.right);
        }
        return root;
    }
}
