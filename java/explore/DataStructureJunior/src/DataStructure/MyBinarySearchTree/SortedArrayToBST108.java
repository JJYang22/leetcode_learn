package DataStructure.MyBinarySearchTree;

import DataStructure.Obj.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/11/19 9:12
 */
public class SortedArrayToBST108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return fun(nums, 0, nums.length - 1);
    }

    private TreeNode fun(int[] nums, int begin, int end) {
        if (begin > end)
            return null;
        int index = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = fun(nums, begin, index - 1);
        root.right = fun(nums, index + 1, end);
        return root;
    }
}
