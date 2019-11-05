package DataStructure.MyLinkList;

import Obj.ListNode;

/**
 * @Author Voidmian
 * @Date 2019/11/4 12:53
 */
public class OddEvenList328 {
    static public void test() {
        ListNode error=null;
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(7);

        head.next = n1;
        //n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        OddEvenList328 oddEvenList328 = new OddEvenList328();
        oddEvenList328.oddEvenList(head);
        System.out.println("finished");

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode cur = even.next;
        while (cur != null) {
            even.next = cur.next;
            ListNode temp1 = odd.next;
            odd.next = cur;
            cur.next = temp1;
            cur = even.next;
            odd = odd.next;
            if (cur != null) {
                cur = cur.next;
                even = even.next;
            } else
                return head;
        }
        return head;
    }
}
