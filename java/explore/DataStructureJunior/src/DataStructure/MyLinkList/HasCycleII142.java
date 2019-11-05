package DataStructure.MyLinkList;

import Obj.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Voidmian
 * @Date 2019/11/2 16:18
 */
public class HasCycleII142 {
    static public void test() {
        HasCycleII142 hasCycleII142 = new HasCycleII142();
        ListNode head = new ListNode(3);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(-4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        System.out.println(hasCycleII142.detectCycle(head).val);
        System.out.println();
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null ) {
            fast = fast.next;
            if (fast.next != null)
                fast = fast.next;
            else
                return null;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        if(fast != slow)
            return null;
        fast=head;
        while (fast != slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}
