package DataStructure.MyLinkList;

import DataStructure.Obj.ListNode;

/**
 * @Author Voidmian
 * @Date 2019/11/2 16:04
 */
public class HasCycleI141 {

    static public void test() {
        HasCycleI141 hasCycleI141=new HasCycleI141();
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        head.next=n1;
        System.out.println(hasCycleI141.hasCycle(head));

    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null)
                fast = fast.next;
            else
                return false;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }



}
