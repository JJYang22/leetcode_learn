package DataStructure.MyBinarySearchTree;

import DataStructure.Obj.TreeNode;

import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/11/17 17:02
 */
public class BinarySearchTreeIterator173 {
    class BSTIterator {
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            while (root != null){
                stack.add(root);
                root = root.left;
            }
        }


        public int next() {
            TreeNode cur = stack.pop();
            int ans = cur.val;
            cur = cur.right;
            while (cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            return ans;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
