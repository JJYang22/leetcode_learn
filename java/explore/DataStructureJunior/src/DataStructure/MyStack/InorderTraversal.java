package DataStructure.MyStack;

import DataStructure.Obj.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/10/29 20:34
 */
public class InorderTraversal {
    static public void test() {
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new LinkedList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
            stack.push(cur);
        }
        while (!stack.isEmpty()) {
            cur = stack.pop();
            ans.add(cur.val);
            if (cur.right != null) {
                cur = cur.right;
                stack.push(cur);
                while (cur.left != null) {
                    cur = cur.left;
                    stack.push(cur);
                }
            }
        }

        return ans;


    }
}
