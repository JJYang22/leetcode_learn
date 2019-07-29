import java.awt.event.MouseAdapter;

public class Solution124 {
    public  static  void main(String args[])
    {
        TreeNode n1=new TreeNode(-10);
        TreeNode n2=new TreeNode(9);
        TreeNode n3=new TreeNode(20);
        TreeNode n4=new TreeNode(15);
        TreeNode n5=new TreeNode(7);
        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n3.right=n5;
        Solution s=new Solution();
        System.out.println(s.maxPathSum(n1));
    }
}


class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {

    int Max124=-(1<<31);
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
         MaxValue(root);
         return Max124;
    }
   public  int MaxValue(TreeNode node)
   {
       int left=0;
       int right=0;
       if(node.left != null)
       {
           left=MaxValue(node.left);
       }
       if(node.right != null)
       {
           right=MaxValue(node.right);
       }
       int temp=Math.max(left,right);
       Max124=Math.max(node.val,Max124);
       Max124=Math.max(node.val+temp,Max124);
       Max124=Math.max(node.val+left+right,Max124);
       return Math.max(node.val,node.val+temp);
   }
}