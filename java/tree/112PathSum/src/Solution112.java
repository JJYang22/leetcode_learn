
public class Solution112 {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(5);
        TreeNode n2=new TreeNode(4);
        TreeNode n3=new TreeNode(8);
        TreeNode n4=new TreeNode(11);
        TreeNode n5=new TreeNode(13);
        TreeNode n6=new TreeNode(4);
        TreeNode n7=new TreeNode(7);
        TreeNode n8=new TreeNode(2);
        TreeNode n9=new TreeNode(1);

        n1.left=n2;
        n1.right=n3;

        n2.left=n4;

        n3.left=n5;
        n3.right=n6;

        n4.left=n7;
        n4.right=n8;

        n6.right=n9;

        Solution s =new Solution();
        System.out.println(s.hasPathSum(n1,22));
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        sum-=root.val;
        if(sum == 0 && root.left==null && root.right ==null)
            return true;

        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }
}