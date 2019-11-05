package DataStructure.MyLinkList;

import Obj.ListNode;

/**
 * @Author Voidmian
 * @Date 2019/11/5 15:22
 */
public class RotateRight61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 )
            return head;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            if (fast.next == null) {
                k=k%(i+1)+i+1;
                fast = head;
            }
            else
                fast = fast.next;
        }
        if(fast == null)
            return head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next=head;
        head=slow.next;
        slow.next=null;
        return head;
    }
}
