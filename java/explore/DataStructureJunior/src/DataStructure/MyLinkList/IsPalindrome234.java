package DataStructure.MyLinkList;

import DataStructure.Obj.ListNode;

/**
 * @Author Voidmian
 * @Date 2019/11/4 13:24
 */
public class IsPalindrome234 {
    static public void test() {
        ListNode error=null;
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        n5.next = n6;
        IsPalindrome234 isPalindrome234 = new IsPalindrome234();
        System.out.println(isPalindrome234.isPalindrome(head));
        System.out.println("finished");

    }
    public boolean isPalindrome(ListNode head) {
        if(head== null || head.next== null)
            return true;
        ListNode pre=head;
        ListNode cur=head.next;
        ListNode fast = head.next.next;
        while (fast!= null && fast.next!=null) {
            cur=pre.next;
            pre.next=cur.next;
            cur.next=head;
            head=cur;
            fast=fast.next.next;
        }
        if(fast != null){
            cur=pre.next.next;
        }else
            cur=pre.next;
        fast=head;
        while (cur!=null){
            if(cur.val != fast.val)
                return false;
            cur=cur.next;
            fast=fast.next;
        }
        return true;
    }
}
