package DataStructure.MyLinkList;

import Obj.ListNode;

/**
 * @Author Voidmian
 * @Date 2019/11/4 12:03
 */
public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode next = head.next;
        head.next=null;
        while (next!=null){
            ListNode cur = next;
            next = cur.next;
            cur.next=head;
            head=cur;
        }

        return head;
    }
}
