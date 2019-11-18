package DataStructure.MyBinarySearchTree;

import DataStructure.Obj.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/11/17 15:37
 */
public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null){
            stack.add(root);
            root = root.left;
        }
        root = stack.pop();
        int temp = root.val;
        temp = root.val;
        root = root.right;
        while (root != null){
            stack.add(root);
            root = root.left;
        }
        while (!stack.isEmpty()){
            root = stack.pop();
            if(root.val <= temp)
                return false;
            temp = root.val;
            root = root.right;
            while (root != null){
                stack.add(root);
                root = root.left;
            }
        }
        return true;
    }

}
