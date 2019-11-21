import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution589 {
    public static void main(String[] args) {

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
    public List<Integer> preorder(Node root) {
        List<Integer> ans=new LinkedList<>();
        if(root== null)
            return ans;
        Stack<Node> nodeStack=new Stack<>();
        nodeStack.push(root);
        while(!nodeStack.isEmpty())
        {
            Node node= nodeStack.pop();
            ans.add(node.val);
            for(int i=node.children.size()-1;i>=0;i--)
            {
                nodeStack.push(node.children.get(i));
            }
        }
        return ans;
    }
}
/*递归
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans=new LinkedList<>();
        pre(root,ans);
        return ans;
    }
    public void pre(Node root,List<Integer> ans)
    {
        if(root ==null)
            return;
        ans.add(root.val);
        for(Node node:root.children)
        {
            pre(node,ans);
        }
    }
}
*/