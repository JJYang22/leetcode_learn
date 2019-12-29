package DynamicProgramming;

import MyStructure.Tree.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/12/26 9:33
 */
public class HouseRobberIII337 {
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        int[] ans = fun(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] fun(TreeNode root) {
        int[] ans = new int[2];
        if (root == null)
            return ans;
        int[] left = fun(root.left);
        int[] right = fun(root.right);
        ans[0] = Math.max(left[1], left[0]) + Math.max(right[0], right[1]);
        ans[1] = left[0] + right[0] + root.val;
        return ans;
    }
}
