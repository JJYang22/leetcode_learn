package DataStructure.MyLinkList;

import DataStructure.Obj.Node138.Node;

/**
 * @Author Voidmian
 * @Date 2019/11/5 9:22
 */
public class CopyRandomList138 {
    static public void test() {
        Node n1 = new Node();

        Node n2 = new Node();
        n1.val=1;
        n2.val=2;
        n1.next = n2;
        n1.random = n2;
        n2.random = n2;
        CopyRandomList138 copyRandomList138 = new CopyRandomList138();
        copyRandomList138.copyRandomList(n1);
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val, cur.next, cur.random);
            cur.next = newNode;
            cur = newNode.next;
        }
        cur = head;
        while (cur != null) {
            if(cur.next.random!=null)
                cur.next.random=cur.next.random.next;
            cur=cur.next.next;
        }
        Node ans=head.next;
        Node ansCur=ans;
        cur=head;
        cur.next=cur.next.next;
        cur=cur.next;
        while (cur!=null){
            ansCur.next=cur.next;
            ansCur=ansCur.next;
            cur.next=ansCur.next;
            cur=cur.next;
        }
        return ans;
    }

//    迭代
//    public Node copyRandomList(Node head) {
//        if(head == null)
//            return null;
//        Map<Node, Node> used = new HashMap<>();
//        Node cur = head;
//        Node ansCur = new Node(head.val, null, null);
//        used.put(head, ansCur);
//        while (cur != null) {
//            if (cur.random != null) {
//                if (used.containsKey(cur.random))
//                    ansCur.random = used.get(cur.random);
//                else {
//                    ansCur.random = new Node(cur.random.val, null, null);
//                    used.put(cur.random, ansCur.random);
//                }
//            }
//            if (cur.next != null) {
//                if (used.containsKey(cur.next))
//                    ansCur.next = used.get(cur.next);
//                else {
//                    ansCur.next = new Node(cur.next.val, null, null);
//                    used.put(cur.next, ansCur.next);
//                }
//            }
//            cur = cur.next;
//            ansCur = ansCur.next;
//        }
//        return used.get(head);
//    }
}
