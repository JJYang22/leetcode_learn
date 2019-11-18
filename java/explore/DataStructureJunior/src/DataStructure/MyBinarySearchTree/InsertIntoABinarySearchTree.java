package DataStructure.MyBinarySearchTree;

import DataStructure.Obj.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/11/17 18:11
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        if(val < root.val){
            root.left = insertIntoBST(root.left,val) ;
        } else {
            root.right =insertIntoBST(root.right,val);
        }
        return root;
    }
}
