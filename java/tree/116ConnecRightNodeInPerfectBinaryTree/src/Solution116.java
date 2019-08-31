import java.util.ArrayList;
import java.util.List;

public class Solution116 {
    public static void main(String[] args) {

    }
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
        Node temp_left = root.left;
        Node temp_right= root .right;
        while(temp_left!=null)
        {
            temp_left.next=temp_right;
            temp_left=temp_left.right;
            temp_right=temp_right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
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