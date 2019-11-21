package DataStructure.MyBinarySearchTree;

import DataStructure.Obj.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyAlmostDuplicate220 {
    static public void test(){
        int k = 1;
        int t = 2147483647;
        int[] nums = {-1,2147483647};
        ContainsNearbyAlmostDuplicate220 containsNearbyAlmostDuplicate220 = new ContainsNearbyAlmostDuplicate220() ;
        System.out.println(containsNearbyAlmostDuplicate220.containsNearbyAlmostDuplicate(nums,k,t));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k < 1 || t < 0)
            return false;
        TreeNode root=null;
        int i = 0;
        if(k + 1 < nums.length){
            for (; i < k + 1; i++) {
                root = insertIntoBST(root,nums[i]);
            }
        } else {
            for (; i < nums.length; i++) {
                root = insertIntoBST(root,nums[i]);
            }
        }
        if(fun(root,t)){
            return true;
        }
        if(k + 1 < nums.length) {
            for (; i < nums.length; i++) {
                root = deleteNode(root, nums[i - k - 1]);
                root = insertIntoBST(root, nums[i]);
                if (fun(root, t)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean fun(TreeNode root,int t){
        if(root == null)
            return false;
        if(root.left != null){
            TreeNode cur = root.left;
            while (cur.right != null){
                cur = cur.right;
            }
            if((long)root.val - cur.val <= (long)t)
                return true;
        }
        if(root.right != null){
            TreeNode cur = root.right;
            while (cur.left != null){
                cur = cur.left;
            }
            if((long)cur.val - root.val <=(long)t)
                return true;
        }
        return fun(root.left,t) || fun(root.right,t);

    }

    private TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val <= root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            TreeNode cur = root.right;
            while(cur != null && cur.left != null){
                cur = cur.left;
            }
            if(cur != null){
                cur.left = root.left;
            } else {
                root.right = root.left;
            }
            return root.right;
        }
        root.left = deleteNode(root.left,key);
        root.right = deleteNode(root.right,key);
        return root;
    }

}
