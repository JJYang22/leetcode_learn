package DataStructure.MyTree;

import DataStructure.Obj.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/11/11 18:18
 */
public class HasPathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return fun(root, sum);
    }

    private boolean fun(TreeNode root, int sum) {
        if (root == null)
            return false;
        int nextSum = sum - root.val;
        if (nextSum == 0 && root.left == null && root.right == null)
            return true;
        return fun(root.left, nextSum) || fun(root.right, nextSum);
    }
}
