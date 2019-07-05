public class Solution24 {
    public  static  void main(String [] args)
    {

    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head != null &&head.next != null)
        {
            ListNode temp=new ListNode(0);
            temp=head.next;
            head.next=temp.next;
            temp.next=head;
            head=temp;
            swap((head.next).next,(head.next));  // 可改为(head.next).next=swapPairs((head.next).next);  递归
        }
        return head;
    }
    private void swap(ListNode head,ListNode pre)
    {
        if(head != null &&head.next != null)
        {
            ListNode temp=new ListNode(0);
            temp=head.next;
            pre.next =temp;
            head.next=temp.next;
            temp.next=head;
            head=temp;
            swap((head.next).next,(head.next));
        }
    }
}

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val =x;
    }
}