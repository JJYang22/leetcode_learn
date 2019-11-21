package DataStructure.MyLinkList;

import DataStructure.Obj.ListNode;
import DataStructure.Obj.TreeNode;

/**
 * @Author Voidmian
 * @Date 2019/11/19 9:34
 */
public class ConvertSortedListToBinarySearchTree109 {
    static public void test() {
        ListNode head = new ListNode(-10);
        ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ConvertSortedListToBinarySearchTree109 convertSortedListToBinarySearchTree109 = new ConvertSortedListToBinarySearchTree109();
        TreeNode ans= convertSortedListToBinarySearchTree109.sortedListToBST(head);
        System.out.println();
    }

    public TreeNode sortedListToBST(ListNode head) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        return fun(prev);
    }
    private TreeNode fun(ListNode prev){
        if (prev.next == null) {
            return null;
        }
        ListNode head = prev;
        ListNode fast = prev.next;
        ListNode slow = prev.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            prev = prev.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.right = fun(slow);
        prev.next = null;
        root.left = fun(head);
        return root;
    }
}
