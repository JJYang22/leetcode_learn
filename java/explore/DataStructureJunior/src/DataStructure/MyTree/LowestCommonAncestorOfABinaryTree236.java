package DataStructure.MyTree;

import DataStructure.Obj.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/11/11 21:02
 */
public class LowestCommonAncestorOfABinaryTree236 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null)
            return right;
        if(right == null)
            return left;
        return root;
    }
//    TreeNode ans;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        fun(root,p,q);
//        return ans;
//    }
//    private int fun(TreeNode root, TreeNode p, TreeNode q){
//        if(root == null)
//            return 0;
//        int temp = fun(root.left,p,q)+fun(root.right,p,q);
//        if(root.val == p.val || root.val == q.val)
//            temp++;
//        if(temp == 2) {
//            ans = root;
//            temp = 0;
//        }
//        return temp;
//    }
}
