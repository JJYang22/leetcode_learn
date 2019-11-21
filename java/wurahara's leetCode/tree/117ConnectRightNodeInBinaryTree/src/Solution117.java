import java.util.List;

import java.util.ArrayList;

public class Solution117 {

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
class Solution
{
    public Node connect (Node root)
    {
        if(root == null)
            return null;
        if(root.left != null)
        {
            if(root.right!= null) {
                root.left.next = root.right;
            }
            else
                root.left.next=find(root);
        }
       if(root.right != null)
           root.right.next=find(root);

        connect(root.right);
        connect(root.left);
        return root;
    }
   private Node find(Node root)
   {
       root=root.next;
       while(root!=null && root.left == null && root.right ==null)
       {
           root=root.next;
       }
       if(root!=null)
       {
           if(root.left!=null)
               return root.left;
           return root.right;
       }
       return null;
   }
}
/*
class Solution {
    public Node connect(Node root) {
        List<List<Node>> res=new ArrayList<>();
        fun(root,1,res);
        for(List<Node> nodeList :res)
        {
            for(Node node :nodeList)
            {
                System.out.print(node.val);
            }
            System.out.println();
        }

        for(List<Node> nodeList :res)
        {
            for(int i=0;i<nodeList.size()-1;i++)
            {
                nodeList.get(i).next=nodeList.get(i+1);
            }
        }
        return root;
    }
    public void fun(Node root,int level, List<List<Node>> res)
    {
        if(root == null)
            return;
        if(res.size()<level)
            res.add(new ArrayList<Node>());
        res.get(level-1).add(root);
        fun(root.left,level+1,res);
        fun(root.right,level+1,res);
    }
}
*/