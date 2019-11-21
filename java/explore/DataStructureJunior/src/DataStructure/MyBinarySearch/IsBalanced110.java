package DataStructure.MyBinarySearch;

import DataStructure.Obj.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/11/18 20:46
 */
public class IsBalanced110 {
    static public void test(){
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(3);
        TreeNode root6 = new TreeNode(4);
        TreeNode root7 = new TreeNode(4);
        root1.left=root2;
        root1.right=root3;
        root2.left=root4;
        root3.right=root5;
        root4.left=root6;
        root5.right=root7;
        IsBalanced110 isBalanced110 = new IsBalanced110();
        System.out.println(isBalanced110.isBalanced(root1));
    }
    public boolean isBalanced(TreeNode root) {
        if(fun(root) == -2)
            return false;
        return true;
    }

    private int fun(TreeNode root){
        if(root == null)
            return -1;
        int left = fun(root.left) ;
        if(left == -2)
            return -2;
        left ++;
        int right = fun(root.right) ;
        if(right == -2)
            return -2;
        right ++;
        if(Math.abs(left -right) >1){
            return -2;
        }
        return Math.max(left,right);
    }
}
