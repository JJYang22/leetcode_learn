import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution173 {
    public static void main(String args[])
    {
        TreeNode node1 =new TreeNode();
        TreeNode node2= new TreeNode(3);
        TreeNode node3 =new TreeNode(15);
        TreeNode node4 =new TreeNode(9);
        TreeNode node5 =new TreeNode(20);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        BSTIterator iter =new BSTIterator(node1);
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
    }
}
class BSTIterator
{
    LinkedList<TreeNode> iter;
    public BSTIterator(TreeNode root) {
        iter=new LinkedList<>();
        if(root !=null)
        {
           iter.push(root);
        while(root.left != null)
        {
            iter.push(root.left);
            root=root.left;
        }
        }
    }

    /** @return the next smallest number */
    public int next() {
        if(hasNext()) {
            TreeNode next= iter.pop();
            if(next.right!=null) {
                TreeNode t = next.right;
                iter.push(t);
                while (t.left!=null) {
                    iter.push(t.left);
                    t = t.left;
                }
            }
            return next.val;
        }
        return 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !iter.isEmpty();
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x)
    {
        val=x;
    }
}