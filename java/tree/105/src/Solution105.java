
public class Solution105 {
    public static void main() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        Solution s = new Solution();
        TreeNode root = s.buildTree(inorder, postorder);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return  build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder, int[] inorder,int preBegin,int preEnd,int inBegin,int inEnd)
    {
        if(inBegin >inEnd)
            return null;
        TreeNode Node =new TreeNode(preorder[preBegin]);
        int temp=intat(inorder,Node.val);
        Node.left=build(preorder,inorder,preBegin+1,preBegin+temp-inBegin,inBegin,temp-1);
        Node.right=build(preorder,inorder,preBegin+temp-inBegin+1,preEnd,temp+1,inEnd);
        return Node;
    }
    private int intat(int [] array ,int index)
    {
        for(int i=0; i<array.length;i++)
        {
            if(array[i] == index)
                return i;
        }
        return -1;
    }
}
