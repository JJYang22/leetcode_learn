import javax.swing.table.TableRowSorter;

public class Solution450 {
    public static void main (String args[])
    {
        TreeNode root = new TreeNode(5);
        TreeNode node1 =new TreeNode(3);
        TreeNode node2 =new TreeNode(6);
        TreeNode node3 =new TreeNode(2);
        TreeNode node4 =new TreeNode(4);
        TreeNode node5 =new TreeNode(7);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.right=node5;
        node2.left=null;
    }
}


class Solution
{
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;

        return nodedel(root,key);

    }
    public TreeNode nodedel (TreeNode root, int key)
    {
        if(root == null)
            return null;
        if(root.val == key)
        {
            if(root.right==null)
                return root.left;
            if(root.left==null)
                return root.right;
            TreeNode temp=root.right;
            while(temp.left !=null)
            {
                temp=temp.left;
            }
            temp.left=root.left;
            root=root.right;
            return root;
        }
        if(key<root.val)
        {
            root.left=nodedel(root.left,key);
        }
        else
        {
            root.right=nodedel(root.right,key);
        }
        return root;
    }
}


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val=x;}
}