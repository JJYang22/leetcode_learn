package DataStructure.MyTree;

import DataStructure.Obj.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/11/11 19:14
 */
public class ConstructBinaryTreeFromPostorderAndInorderTraversal106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return fun(postorder, 0, inorder, 0, postorder.length);
    }

    private TreeNode fun(int[] postorder, int postBegin, int[] inorder, int inBegin, int length) {

        TreeNode root = new TreeNode(postorder[postBegin + length - 1]);
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
            root.right = fun(postorder, postBegin + leftLength, inorder, inBegin + 1 + leftLength, rightLength);
        }
        if (leftLength != 0) {
            root.left = fun(postorder, postBegin, inorder, inBegin, leftLength);
        }
        return root;
    }
}
