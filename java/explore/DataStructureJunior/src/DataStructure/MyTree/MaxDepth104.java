package DataStructure.MyTree;

import DataStructure.Obj.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/11/11 16:40
 */
public class MaxDepth104 {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(fun(root.left)+1,fun(root.right)+1);
    }
    private int fun(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(fun(root.left)+1,fun(root.right)+1);
    }
}
