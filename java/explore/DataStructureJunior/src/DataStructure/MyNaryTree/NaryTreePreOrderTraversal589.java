package DataStructure.MyNaryTree;

import DataStructure.Obj.NaryTreeNode.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/11/19 10:20
 */
public class NaryTreePreOrderTraversal589 {
    public List<Integer> preorder(Node root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            if (root.children != null && root.children.size() != 0) {
                for (int i = root.children.size() - 1; i >= 0; i--) {
                    stack.add(root.children.get(i));
                }
            }
        }
        return ans;
    }
//    public List<Integer> preorder(Node root) {
//        if(root == null)
//            return new ArrayList<>();
//        List<Integer> ans = new ArrayList<>();
//        fun(root,ans);
//        return ans;
//    }
//    private void fun (Node root,List<Integer> ans) {
//        ans.add(root.val);
//        for (Node n: root.children
//             ) {
//            fun(n,ans);
//        }
//    }
}
