package DataStructure.MyBinarySearchTree;


import DataStructure.Obj.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/11/18 9:39
 */
public class KthLargest {
    static public void test() {
        int[] arr = new int[0];
        int k = 2;
        KthLargest kthLargest = new KthLargest(k,arr);
        System.out.println(kthLargest.add(-3));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(0));
        System.out.println(kthLargest.add(4));
    }
    TreeNode nodeRoot;
    int count = 0;
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            nodeRoot = insertIntoBST(nodeRoot, nums[i]);
            count++;
        }
        for (int i = 0; i < nums.length - k; i++) {
            nodeRoot = deleteMinIntoBST(nodeRoot);
        }
    }

    public int add(int val) {
        nodeRoot = insertIntoBST(nodeRoot, val);
        count++;
        if (count > k) {
            nodeRoot = deleteMinIntoBST(nodeRoot);
        } else if (count < k) {
            return -1;
        }
        TreeNode cur = nodeRoot;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.val;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public TreeNode deleteMinIntoBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            count--;
            if (root.right == null)
                return null;
            return root.right;
        }
        root.left = deleteMinIntoBST(root.left);
        return root;
    }
}




