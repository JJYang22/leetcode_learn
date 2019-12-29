package DynamicProgramming;

import MyStructure.Tree.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/12/23 13:53
 */
public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum124 binaryTreeMaximumPathSum124 = new BinaryTreeMaximumPathSum124();
        TreeNode n1 = new TreeNode(-2);
        TreeNode n2 = new TreeNode(-1);
//        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
//        n1.left = n3;
        int ans = binaryTreeMaximumPathSum124.maxPathSum(n1);
        System.out.println();
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root != null)
            max = Math.max(fun(root), max);
        return max;
    }

    private int fun(TreeNode root) {
        if (root.left == null && root.right == null)
            return root.val;
        int left = 0;
        int right = 0;

        int total = root.val;
        int ans = Integer.MIN_VALUE;
        if (root.right != null) {
            right = fun(root.right);
            total += right;
            ans = right;
        }

        if (root.left != null) {
            left = fun(root.left);
            total += left;
            if (root.right == null)
                ans = left;
            else
                ans = Math.max(left, right);
        }


        if (max < total) {
            max = total;
        }

        if (max < ans) {
            max = ans;
        }
        if (ans <= 0) {
            ans = root.val;
        } else {
            ans += root.val;
        }
        if (max < ans) {
            max = ans;
        }

        return ans;

    }
}
