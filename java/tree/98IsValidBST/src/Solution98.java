public class Solution98 {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(1);
        n1.left=n2;
        Solution s=new Solution();
        System.out.println(s.isValidBST(n1));
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
    public boolean isValidBST(TreeNode root) {
        if(root == null )
            return true;
        if(root.left == null && root.right ==null)
            return true;
        if(isValidBST(root.left) == false)
            return false;
        if(isValidBST(root.right) ==false)
            return false;
        if(root.left!=null && root.val <=findleft(root.left).val )
            return false;
        if(root.right!=null && root.val>=findright(root.right).val)
            return  false;
        return true;

    }
    public TreeNode findleft(TreeNode root)
    {
        if(root.right == null)
            return root;
        return findleft(root.right);
    }
    public TreeNode findright(TreeNode root)
    {
        if(root.left == null)
            return root;
        return findright(root.left);
    }
}