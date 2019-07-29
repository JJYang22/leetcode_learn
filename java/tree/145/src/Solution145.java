import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class Solution145 {
    public static void main(String args[])
    {
        TreeNode node1=new TreeNode(7);
        TreeNode node2 =new TreeNode(5);
        TreeNode node3=new TreeNode(6);
        TreeNode node4=new TreeNode(1);
        TreeNode node5=new TreeNode(4);
        TreeNode node6=new TreeNode(2);
        TreeNode node7=new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node5.left=node6;
        node5.right=node7;
        Solution s=new Solution();
        List <Integer> ans =s.postorderTraversal(node1);

        for(Integer t:ans)
        {
            System.out.println(t);
        }
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

  /*迭代*/
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList <Integer> ans =new LinkedList<>();
        LRD(root ,ans);
        return ans;
    }
    private void LRD(TreeNode curr,LinkedList<Integer>  ans )
    {
        LinkedList <TreeNode> node =new LinkedList<>();
        if(curr==null)
            return;
        node.push(curr);
        while( !node.isEmpty())
        {
           curr=node.pop();
            ans.push(curr.val);
            if(curr.left !=null)
            node.push(curr.left);
            if(curr.right !=null)
                node.push(curr.right);
        }
    }
}



/* 递归
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList <Integer> ans =new LinkedList<>();
        LRD(root ,ans);
            return ans;
    }
    private void LRD(TreeNode root,List<Integer>  ans )
    {
        if(root == null)
            return ;
        LRD(root.left,ans);
        LRD(root.right,ans);
        ans.add(root.val);
        System.out.println(root.val);
    }
}*/