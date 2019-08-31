import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution429 {
    public static void main(String[] args) {
        Node n1=new Node()
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> ans=new ArrayList<>();
        funlevelorder(root,ans,0);
        return ans;
        }
public void funlevelorder(Node root, ArrayList<List<Integer>> ans,int level)
        {
        if(root== null)
        return ;
        if(ans.get(level).isEmpty())
        {
        ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        for(Node node : root.children)
        {
        if(node!=null)
        funlevelorder(node,ans,level+1);
        }
        }
        }