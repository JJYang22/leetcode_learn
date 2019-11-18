package DataStructure.MyBinarySearchTree;

import DataStructure.Obj.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/11/17 18:10
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val == val){
            return root;
        }
        TreeNode ans = searchBST(root.left,val);
        if(ans == null) {
            ans = searchBST(root.right,val);
        }
        return ans;
    }
}
