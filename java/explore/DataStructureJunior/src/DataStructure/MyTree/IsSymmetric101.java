package DataStructure.MyTree;

import DataStructure.Obj.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/11/11 16:53
 */
public class IsSymmetric101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return fun(root.left,root.right);
    }
    private boolean fun(TreeNode left,TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        return fun(left.left,right.right) && fun(left.right,right.left);
    }
}
