public class Solution110 {
    public static void main(String [] args)
    {
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(9);
        TreeNode node3=new TreeNode(20);
        TreeNode node4=new TreeNode(15);
        TreeNode node5=new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        node2.left=null;
        node2.right=null;
        node5.left=null;
        node5.right=null;
        node4.left=null;
        node4.right=null;

        Solution s=new Solution();
        System.out.println(s.isBalanced(node1));
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root ==null)
            return true;
        else
        {
            return (Math.abs(high(root.left)-high(root.right))<=1)&&(isBalanced(root.left)&&isBalanced(root.right));
        }

    }
    private int high(TreeNode root)
    {
        if(root==null)
            return 0;
        else
            return Math.max(high(root.left),high(root.right))+1;
    }
}

/*
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root ==null)
            return true;
        else
        {
            return high(root) >0;
        }

    }

    private int high(TreeNode root)
    {
        if(root==null)
            return 1;
        else
        {
            int left=high(root.left);
            int right=high(root.right);
            if(Math.abs(left-right)>1)
                return 0;
            if(left>0 && right>0 )
                return Math.max(left,right)+1;
        }
        return 0;
    }
}
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}