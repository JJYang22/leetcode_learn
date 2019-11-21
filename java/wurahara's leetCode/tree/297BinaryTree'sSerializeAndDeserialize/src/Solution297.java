import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Solution297 {
    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        TreeNode node1 =new TreeNode(2);
        TreeNode node2 =new TreeNode(3);
        TreeNode node3 =new TreeNode(4);
        TreeNode node4 =new TreeNode(5);

        root.left=node1;
        root.right=node2;

        node2.right=node4;
        node2.left=node3;

        Codec codec=new Codec();
        String s=codec.serialize(root);

        System.out.println(s);
        TreeNode ans=codec.deserialize(s);
        codec.display(ans);
    }
}
 class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String str=new String();
        if(root== null)
        {
           str+="null";
        }
        else
        {
            String left=serialize(root.left);
            String right=serialize(root.right);
            str+=String.valueOf(root.val)+","+left+","+right;
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] temp=data.split(",");
        ArrayList <String> ser=new ArrayList<>(Arrays.asList(temp));
        return de(ser);
    }
    private TreeNode de(ArrayList <String> ser)
    {
        if(ser.get(0)== null || ser.get(0).compareTo("null") == 0) {
            ser.remove(0);
            return null;
        }
        TreeNode root= new TreeNode(Integer.parseInt(ser.get(0)));
        ser.remove(0);
        root.left=de(ser);
        root.right=de(ser);
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