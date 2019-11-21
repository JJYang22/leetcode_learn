package DataStructure.MyNaryTree;

import DataStructure.Obj.NaryTreeNode.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/11/19 10:40
 */
public class NaryTreePostOrderTraversal590 {
    public List<Integer> postorder(Node root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(0,root.val);
            if (root.children != null && root.children.size() != 0) {
                for (int i = 0; i <root.children.size() ; i++) {
                    stack.add(root.children.get(i));
                }
            }
        }
        return ans;
    }
}
