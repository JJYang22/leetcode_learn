import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution652 {
    public static void main (String args[])
    {
        TreeNode root = new TreeNode(1);
        TreeNode node1 =new TreeNode(2);
        TreeNode node2 =new TreeNode(3);
        TreeNode node3 =new TreeNode(4);
        TreeNode node4 =new TreeNode(2);
        TreeNode node5 =new TreeNode(4);
        TreeNode node6 =new TreeNode(4);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node2.right=node5;
        node2.left=node4;
        node4.left=node6;
        Solution s=new Solution();
        s.findDuplicateSubtrees(root);
    }


}


class Solution
{
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List <TreeNode> ans= new LinkedList<>();
        HashMap map=new HashMap();
        if(root == null)
            return ans;
        find(root,ans,map);
        return ans;
    }
    public String find(TreeNode root,List ans,HashMap map)
    {
        if(root == null)
            return null;
        String left=find(root.left,ans,map);
        String right=find(root.right,ans,map);
        String mid= root.val+""+left+""+right;

        map.put(mid,(int)map.getOrDefault(mid,0)+1);
        if((int)map.get(mid)==2)
            ans.add(root);
        return mid;
    }
}


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val=x;}
}