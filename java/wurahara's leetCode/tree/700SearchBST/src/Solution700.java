public class Solution700 {
    public static void main(String[] args) {

    }
}


  class TreeNode {
   int val;
     TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val== val)
            return root;
        if(root.val<val)
            return searchBST(root.right,val);
        return searchBST(root.left,val);
    }
}