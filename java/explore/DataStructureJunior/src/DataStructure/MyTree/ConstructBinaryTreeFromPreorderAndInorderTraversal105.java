package DataStructure.MyTree;

import DataStructure.Obj.TreeNode;

import java.util.Arrays;

/**
 * @Author Voidmian
 * @Date 2019/11/11 18:27
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    static public void test() {
        ConstructBinaryTreeFromPreorderAndInorderTraversal105 constructBinaryTreeFromPreorderAndInorderTraversal105 = new ConstructBinaryTreeFromPreorderAndInorderTraversal105();
        int[] preoder = {3, 9, 20, 15, 8};
        int[] inorder = {9, 3, 15, 20, 7};
        constructBinaryTreeFromPreorderAndInorderTraversal105.buildTree(preoder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return fun(preorder, 0, inorder, 0, preorder.length);
    }

    private TreeNode fun(int[] preorder, int preBegin, int[] inorder, int inBegin, int length) {

        TreeNode root = new TreeNode(preorder[preBegin]);
        int leftLength = 0;
        int rightLength = 0;
        for (int i = inBegin; i < inBegin + length; i++) {
            if (inorder[i] == root.val) {
                leftLength = i - inBegin;
                break;
            }
        }
        rightLength = length - leftLength - 1;
        if (rightLength != 0) {
            root.right = fun(preorder, preBegin + 1 + leftLength, inorder, inBegin + 1 + leftLength, rightLength);
        }
        if (leftLength != 0) {
            root.left = fun(preorder, preBegin + 1, inorder, inBegin, leftLength);
        }
        return root;
    }
}
