import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution230 {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(1);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(2);
        node1.left=node2;
        node1.right=node3;
        node2.right=node4;
        Solution s=new Solution();
        System.out.println(s.kthSmallest(node1,3));

    }
}
/*
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> res=new ArrayList<>(k);
        display(root,res,k);
        return res.get(k-1);
    }
    public void display(TreeNode root,ArrayList<Integer> res,int k)
    {
        if(root!=null && res.size()<k)
        {
            display(root.left,res,k);
                res.add(root.val);
            display(root.right,res,k);
        }
    }
}
*/
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x)
    {
        val=x;
    }
}