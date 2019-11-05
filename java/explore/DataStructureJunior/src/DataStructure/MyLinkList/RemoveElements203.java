package DataStructure.MyLinkList;

import Obj.ListNode;

/**
 * @Author Voidmian
 * @Date 2019/11/4 12:21
 */
public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        while (head!= null && head.val == val){
            head=head.next;
        }
        ListNode cur = head;
        if(head == null)
            return head;
        while ( cur.next != null) {
            ListNode next = cur.next;
            if(next.val == val)
                cur.next=next.next;
            else
                cur=cur.next;
        }
        return head;
    }
}
