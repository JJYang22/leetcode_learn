package DataStructure.MyTree;

import DataStructure.Obj.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/11/11 16:12
 */
public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        ans.add(0,root.val);
        stack.add(root.left);
        root = root.right;
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                continue;
            }
            ans.add(0,root.val);
            stack.add(root.left);
            root = root.right;
        }
        return ans;
    }
//    public List<Integer> postorderTraversal(TreeNode root) {
//            List<Integer> ans = new ArrayList<>();
//        if (root == null) {
//            return ans;
//        }
//        fun(root.left, ans);
//        fun(root.right, ans);
//        ans.add(root.val);
//        return ans;
//    }
//
//    private void fun(TreeNode root, List<Integer> ans) {
//        if (root == null)
//            return;
//        fun(root.left, ans);
//        fun(root.right, ans);
//        ans.add(root.val);
//    }
}
