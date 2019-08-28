public class Solution236 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(-2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;

        node2.left=node4;
        node2.right = node5;

        node4.left=node6;
        Solution s = new Solution();
        TreeNode p=new TreeNode(8);
        TreeNode q=new TreeNode(4);
        TreeNode ans= s.lowestCommonAncestor(node1,p,q);
        System.out.println(ans.val);

    }
}
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.fun(root,p,q);
        return this.ans;
    }
    public int  fun(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null)
            return 0 ;
        int left=fun(root.left,p,q);
        int right=fun(root.right,p,q);
        int mid=0;
        if(root.val==p.val || root.val==q.val)
        {
            mid=1;
        }
        if(mid + left +right == 2) {
            this.ans = root;
            return 0;
        }
        return mid+right+left;
    }
}