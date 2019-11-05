package DataStructure.MyLinkList;

import Obj.ListNode;

/**
 * @Author Voidmian
 * @Date 2019/11/4 10:51
 */
public class RemoveNthFromEnd19 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head, slow = head;
            for (int i = 0; i < n; i++) {
                if (fast.next != null)
                    fast = fast.next;
                else
                    return null;
            }
            if (fast == null)
                return head.next;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }
}
