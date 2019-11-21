import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution106 {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        if (inorder.length > 0) {
//            TreeNode Node = new TreeNode(postorder[postorder.length - 1]);
//            int temp = intat(inorder,Node.val);
//            int [] inorder_left =new int[temp];
//            int [] postorder_left =new int[temp];
//            int [] inorder_right =new int[inorder.length-1-temp];
//            int [] postorder_right =new int[inorder.length-1-temp];
//            for(int i=0;i<inorder_left.length;i++)
//            {
//                inorder_left[i]=inorder[i];
//            }
//            for(int i=0;i<inorder_right.length;i++)
//            {
//                inorder_right[i]=inorder[temp+1+i];
//            }
//            for(int i=0;i<postorder_left.length;i++)
//            {
//                postorder_left[i]=postorder[i];
//            }
//
//            for(int i=0;i< postorder_right.length;i++)
//            {
//                postorder_right[i]=postorder[i+postorder_left.length];
//            }
//            Node.left=buildTree(inorder_left,postorder_left);
//            Node.right=buildTree(inorder_right,postorder_right);
//            return Node;
//        }
//        return null;
       return  build(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    private TreeNode build(int[] inorder, int[] postorder,int inBegin,int inEnd,int postBegin,int postEnd)
    {
        if(inBegin >inEnd)
            return null;
        TreeNode Node =new TreeNode(postorder[postEnd]);
        int temp=intat(inorder,Node.val);
        Node.left=build(inorder,postorder,inBegin,temp-1,postBegin,postBegin+temp-inBegin-1);
        Node.right=build(inorder,postorder,temp+1,inEnd,postBegin+temp-inBegin,postEnd-1);
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
