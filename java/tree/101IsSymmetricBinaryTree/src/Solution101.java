import java.util.Stack;

public class Solution101 {
    public static void main(String[] args) {

    }
}
  class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        Stack <TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        nodeStack.push(root);
        while(!nodeStack.isEmpty())
        {
            TreeNode Node1=nodeStack.pop();
            TreeNode Node2=nodeStack.pop();
            if(Node1 == null && Node2==null)
                continue;

            if(Node1 == null || Node2 ==null || Node1.val!=Node2.val)
            {
                return false;
            }
            nodeStack.push(Node1.left);
            nodeStack.push(Node2.right);
            nodeStack.push(Node1.right);
            nodeStack.push(Node2.left);
        }
        return true;
    }

}