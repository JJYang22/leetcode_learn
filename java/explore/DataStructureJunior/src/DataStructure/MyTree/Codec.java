package DataStructure.MyTree;

import DataStructure.Obj.TreeNode;

import javax.print.DocFlavor;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Voidmian
 * @Date 2019/11/11 21:46
 */
public class Codec {
    static public void test() {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        //    n5.left = n6;
        Codec codec = new Codec();
        String str = codec.serialize(n1);
        System.out.println(str);
        TreeNode ans = codec.deserialize(str);
        System.out.println();
    }

    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    sb.append("null,");
                } else {
                    sb.append(Integer.toString(cur.val) + ",");
                        queue.offer(cur.left);
                        queue.offer(cur.right);
                }
            }
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] strings = data.split(",");
        int temp = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strings[temp]));
        Queue<TreeNode> queue = new LinkedList<>();
        temp++;
        queue.offer(root);
        while (temp < strings.length) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode cur = queue.poll();
                if (temp < strings.length) {
                    if (strings[temp].equals("null")) {
                        temp++;
                    } else {
                        cur.left = new TreeNode(Integer.parseInt(strings[temp++]));
                        queue.offer(cur.left);
                    }
                    if (strings[temp].equals("null")) {
                        temp++;
                    } else {
                        cur.right = new TreeNode(Integer.parseInt(strings[temp++]));
                        queue.offer(cur.right);
                    }
                } else {
                    temp ++;
                }
            }
        }
        return root;
    }
}
