import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution590 {
    public static void main(String[] args) {
        Node n2=new Node(2,null);

        Node n4=new Node(4,null);

        Node n5=new Node(5,null);

        Node n7=new Node(7,null);

        List <Node> l6=new LinkedList<>();
        l6.add(n7);
        Node n6=new Node(6,l6);

        List <Node> l3=new LinkedList<>();
        l3.add(n5);
        l3.add(n6);
        Node n3=new Node(3,l3);

        List <Node> l1=new LinkedList<>();
        l1.add(n3);
        l1.add(n2);
        l1.add(n4);
        Node n1=new Node(1,l1);

        Solution s=new Solution();
        List <Integer>ans=s.preorder(n1);
        for(Integer i:ans)
        {
            System.out.println(i);
        }
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans=new LinkedList<>();
        if(root== null)
            return ans;
        Stack<Node> nodeStack=new Stack<>();
        Node node =root;
        nodeStack.push(root);
        while(!nodeStack.isEmpty()) {
            node = nodeStack.pop();
            ans.add(0, node.val);
            if (node.children != null && node.children.size() > 0) {
                for (int i =0 ; i <node.children.size(); i++) {
                    nodeStack.push(node.children.get(i));
                }

            }
        }


        return ans;
    }
    public void display(Stack <Node> nodeStack)
    {
        for(Node n:nodeStack)
        {
            System.out.print(n.val+" ");
        }
        System.out.println();
    }

}
/*
class Solution {
    public List<Integer> postorder(Node root) {
        List <Integer> ans=new ArrayList<>();
        post(root,ans);
        return ans;
    }
    private void post(Node root,List <Integer> ans)
    {
        if(root==null)
            return ;
        for(Node node :root.children)
        {
            post(node,ans);
        }
        ans.add(root.val);

    }
}*/