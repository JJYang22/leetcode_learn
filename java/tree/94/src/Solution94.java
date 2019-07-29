import java.util.LinkedList;
import java.util.List;

public class Solution94 {
    public static void main(String args[])
    {
      TreeNode node1=new TreeNode(6);
      TreeNode node2 =new TreeNode(2);
      TreeNode node3=new TreeNode(7);
      TreeNode node4=new TreeNode(1);
      TreeNode node5=new TreeNode(4);
      TreeNode node6=new TreeNode(3);
      TreeNode node7=new TreeNode(5);
      node1.left=node2;
      node1.right=node3;
      node2.left=node4;
      node2.right=node5;
      node5.left=node6;
      node5.right=node7;
      Solution s=new Solution();
      s.inorderTraversal(node1);
    }
}
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
/*莫里斯遍历*/
class Solution {
    List<Integer> ans= new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        Morris(root);
        return ans;
    }
    private void  Morris(TreeNode curr)
    {

        while (curr != null )
        {

            if(curr.left == null)
            {
                ans.add(curr.val);
                curr=curr.right;
            }
            else
            {
                TreeNode pren=curr.left;
                while(pren.right!=null && pren.right!= curr)
                    pren=pren.right;
                if(pren.right==null) {
                    pren.right = curr;
                    curr=curr.left;
                }
                    else {
                    pren.right = null;
                    ans.add(curr.val);
                    curr = curr.right;

                }
            }
        }
    }
}


/*递归
class Solution {
    List<Integer> ans= new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        LDR(root);
        return ans;
    }
    private void  LDR(TreeNode root)
    {
        if(root != null)
        {
            if(root.left !=null )
                LDR(root.left);
            ans.add(root.val);
            System.out.println(root.val);
            if(root.right != null )
                LDR(root.right);
        }
    }
}
*/

/*迭代
class Solution {

    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> ans =new LinkedList<>();
        LinkedList<TreeNode> iterator= new LinkedList<>();
        while(root != null||!iterator.isEmpty())
        {
            while(root!=null)
            {
                iterator.push(root);
                root=root.left;
            }
            TreeNode iter=iterator.pop();
            ans.add(iter.val);
            System.out.println(iter.val);
            root=iter.right;

        }
        return ans;
    }

}
*/