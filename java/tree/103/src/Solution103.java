import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution103 {
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
        List<List<Integer>> ans= s.zigzagLevelOrder(node1);
        for (List<Integer> a:ans)
        {
            for(Integer i:a)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(root == null)
            return ans;
        else {
            int level=0;
            ArrayList<TreeNode> temp = new ArrayList<>(1);
            temp.add(root);
            while(!temp.isEmpty())
            {
                int now=temp.size();
                ans.add(new ArrayList<Integer>(1));
                for(int i=0;i<now;i++)
                {
                    if((level & 1)==0)
                        ans.get(level).add(temp.get(i).val);
                    else
                        ans.get(level).add(temp.get(now-1-i).val);
                    if(temp.get(i).left!=null) {
                        temp.add(temp.get(i).left);
                    }
                    if(temp.get(i).right!=null) {
                        temp.add(temp.get(i).right);
                    }
                }
                for(int i=0;i<now;i++)
                {
                    temp.remove(0);
                }
                level++;
            }
            return ans;
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}