package DataStructure.MyHashMap;

import DataStructure.Obj.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Voidmian
 * @Date 2019/11/9 19:33
 */
public class FindDuplicateSubtrees652 {
    static public void test(){
        FindDuplicateSubtrees652 findDuplicateSubtrees652 = new FindDuplicateSubtrees652();
        TreeNode root =new TreeNode(1);
        TreeNode n1 =new TreeNode(2);
        TreeNode n2 =new TreeNode(3);
        TreeNode n3 =new TreeNode(4);
        TreeNode n4 =new TreeNode(2);
        TreeNode n5 =new TreeNode(4);
        TreeNode n6 =new TreeNode(4);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n2.left=n4;
        n2.right=n5;
        n4.left=n6;
        List<TreeNode> ans = findDuplicateSubtrees652.findDuplicateSubtrees(root);
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return  new ArrayList<>();
        }
        Map<String,TreeNode> used = new HashMap<>();
        fun(root, used);
        List<TreeNode> ans = used.values().stream().filter(e-> e!=null).collect(Collectors.toList());
        return ans;
    }

    private String fun(TreeNode root, Map<String,TreeNode> used ) {
        if (root == null)
            return " ";
        String left = fun(root.left, used);
        String right = fun(root.right, used);
        String node = Integer.toString(root.val)+left+right;
        if(used.containsKey(node)){
            used.put(node,root);
        }else {
            used.put(node,null);
        }
        return node;
    }

}
