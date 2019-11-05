package DataStructure.MyLinkList;

import DataStructure.MyStack.MyStack;

/**
 * @Author Voidmian
 * @Date 2019/11/2 13:51
 */
public class MyLinkedList {

    private Node head;
    private Node tail;
    private int length;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node();
        tail=head;
        length=0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index <0 || index+1>length)
            return -1;
        if(index+1 == length)
            return tail.val;
        Node cur =head.next;
        for(int i = 0;i<index;i++) {
            cur=cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node cur= new Node(val);
        if(head.next==null)
            tail=cur;
        cur.next=head.next;
        head.next=cur;
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        length++;
        tail.next=new Node(val);
        tail=tail.next;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if( index > length)
            return;
        if(index <= 0){
            addAtHead(val);
            return;
        }
        if(index == length){
            addAtTail(val);
            return;
        }
        Node cur = head;
        for(int i= 0;i<index;i++){
            cur=cur.next;
        }
        cur.next=new Node(val,cur.next);
        length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index +1 >length)
            return;
        Node cur = head;
        for (int i = 0; i <index ; i++) {
            cur=cur.next;
        }
        if(index+1 == length)
            tail=cur;
        cur.next=cur.next.next;
        length--;
    }

    private class Node{
        public int val;
        public Node next;
        public Node(){}

        public Node(int val){
            this.val=val;
            this.next=null;
        }
        public Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
    }
}

//public class MyLinkedList {
//    static public void test(){
//        MyLinkedList myLinkedList=new MyLinkedList();
//        myLinkedList.get(0);
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtIndex(1,10);
//        myLinkedList.deleteAtIndex(1);
//        myLinkedList.addAtTail(2);
//        myLinkedList.addAtTail(4);
//        myLinkedList.addAtIndex(2,3);
//        int ans=myLinkedList.get(3);
//        System.out.println("finished");
//    }
//
//
//    private Node head;
//    private Node tail;
//    private int length;
//    /** Initialize your data structure here. */
//    public MyLinkedList() {
//        head = new Node();
//        tail=head;
//        length=0;
//    }
//
//    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
//    public int get(int index) {
//        if(index <0 || index+1>length)
//            return -1;
//        if(index+1 == length)
//            return tail.val;
//        Node cur =head.next;
//        for(int i = 0;i<index;i++) {
//            cur=cur.next;
//        }
//        return cur.val;
//    }
//
//    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
//    public void addAtHead(int val) {
//        Node cur= new Node(val);
//        if(head.next==null)
//            tail=cur;
//        cur.next=head.next;
//        head.next=cur;
//        length++;
//    }
//
//    /** Append a node of value val to the last element of the linked list. */
//    public void addAtTail(int val) {
//        length++;
//        tail.next=new Node(val);
//        tail=tail.next;
//    }
//
//    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
//    public void addAtIndex(int index, int val) {
//        if( index > length)
//            return;
//        if(index <= 0){
//            addAtHead(val);
//            return;
//        }
//        if(index == length){
//            addAtTail(val);
//            return;
//        }
//        Node cur = head;
//        for(int i= 0;i<index;i++){
//            cur=cur.next;
//        }
//        cur.next=new Node(val,cur.next);
//        length++;
//    }
//
//    /** Delete the index-th node in the linked list, if the index is valid. */
//    public void deleteAtIndex(int index) {
//        if(index +1 >length)
//            return;
//        Node cur = head;
//        for (int i = 0; i <index ; i++) {
//            cur=cur.next;
//        }
//        if(index+1 == length)
//            tail=cur;
//        cur.next=cur.next.next;
//        length--;
//    }
//
//     private class Node{
//        public int val;
//        public Node next;
//        public Node(){}
//
//         public Node(int val){
//             this.val=val;
//             this.next=null;
//         }
//         public Node(int val,Node next){
//             this.val=val;
//             this.next=next;
//         }
//    }
//}
