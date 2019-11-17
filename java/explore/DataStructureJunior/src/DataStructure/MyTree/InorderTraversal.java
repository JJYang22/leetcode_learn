package DataStructure.MyTree;

import DataStructure.Obj.TreeNode;

import javax.net.ssl.SSLContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/11/11 16:06
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack <TreeNode> stack = new Stack<>();
        stack.add(root);
        while (root.left!= null){
            root = root.left;
            stack.add(root);
        }
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            if(cur.right != null){
                cur=cur.right;
                stack.add(cur);
                while (cur.left!= null){
                    cur = cur.left;
                    stack.add(cur);
                }
            }
        }
        return ans;
    }
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        if (root == null) {
//            return ans;
//        }
//        fun(root.left, ans);
//        ans.add(root.val);
//        fun(root.right, ans);
//        return ans;
//    }
//
//    private void fun(TreeNode root, List<Integer> ans) {
//        if (root == null)
//            return;
//        fun(root.left, ans);
//        ans.add(root.val);
//        fun(root.right, ans);
//    }
}
