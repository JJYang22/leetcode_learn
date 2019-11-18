package DataStructure.MyBinarySearchTree;

import DataStructure.Obj.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/11/18 11:14
 */
public class LowestCommonAncestorOfABinarySearchTree235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = null, right = null;
        if (root.val > p.val || root.val > q.val)
             left = lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val || root.val < q.val)
             right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
