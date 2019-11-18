package DataStructure.MyBinarySearchTree;

import DataStructure.Obj.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/11/17 18:11
 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            TreeNode cur = root.right;
            while(cur != null && cur.left != null){
                cur = cur.left;
            }
            if(cur != null){
                cur.left = root.left;
            } else {
                root.right = root.left;
            }
            return root.right;
        }
        root.left = deleteNode(root.left,key);
        root.right = deleteNode(root.right,key);
        return root;
    }
}
