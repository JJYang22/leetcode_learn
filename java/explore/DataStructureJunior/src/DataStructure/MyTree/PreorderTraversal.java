package DataStructure.MyTree;

import DataStructure.Obj.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/11/11 15:41
 */
public class PreorderTraversal {
    //    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        if (root == null) {
//            return ans;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        ans.add(root.val);
//        stack.add(root.right);
//        root = root.left;
//        while (root != null || !stack.isEmpty()) {
//            if (root == null) {
//                root = stack.pop();
//                continue;
//            }
//            ans.add(root.val);
//            stack.add(root.right);
//            root = root.left;
//        }
//        return ans;
//    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        fun(root.left, ans);
        fun(root.right, ans);
        return ans;
    }

    private void fun(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);
        fun(root.left, ans);
        fun(root.right, ans);
    }
}
