package DataStructure.MyLinkList;

import DataStructure.Obj.ListNode;

/**
 * @Author Voidmian
 * @Date 2019/11/2 19:08
 */
public class GetIntersectionNode160 {
    static public void test(){
        ListNode headA = new ListNode(4);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode headB = new ListNode(5);
        ListNode n5 = new ListNode(0);
        ListNode n6 = new ListNode(1);

        headA.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        headB.next=n5;
        n5.next=n6;
        n6.next=n2;
        GetIntersectionNode160 getIntersectionNode160 = new GetIntersectionNode160();
        getIntersectionNode160.getIntersectionNode(headA, headB);
        System.out.println("finished");

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        ListNode tailA=null,tailB=null;
        while (p1 != p2){
            if(p1.next == null) {
                tailA = p1;
                p1=headB;
            }else
            p1=p1.next;
            if(p2.next == null) {
                tailB =p2;
                p2=headA;
            }else
            p2=p2.next;
            if(tailB != tailA && tailA != null && tailB != null)
                return null;
        }
        return p1;
    }
}
