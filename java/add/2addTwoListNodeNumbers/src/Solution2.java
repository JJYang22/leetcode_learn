import javax.sound.midi.Soundbank;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        Solution s= new Solution();
        ListNode temp;


        ListNode l1=new ListNode(1);
        temp=l1;
        temp.next=new ListNode(8);
//        temp=temp.next;
//        temp.next=new ListNode(5);

        ListNode l2=new ListNode(0);
//        temp=l2;
//        temp.next=new ListNode(8);
//        temp=temp.next;
//        temp.next=new ListNode(5);


        ListNode ans=s.addTwoNumbers(l1,l2);
        System.out.print(ans.val);
        while (ans.next!=null)
        {
            ans=ans.next;
            System.out.print(ans.val);
        }
    }
}



   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2==null)
            return null;
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        int up=0;
        while (l1 !=null || l2 !=null )
        {
            if(temp.next==null)
                temp.next=new ListNode(0);
            temp=temp.next;
            int l=0,r= 0;
            if(l1!=null) {
                l=l1.val;
                l1=l1.next;
            }
            if(l2!=null) {
                r=l2.val;
                l2=l2.next;
            }
            up+=l+r;
            temp.val=up%10;
            up=up/10;
            if( up>0 ) {
                temp.next=new ListNode(up);
            }
        }
        return ans.next;
    }
}





//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        return addfun(l1,l2,0);
//    }
//    private ListNode addfun(ListNode l1, ListNode l2,int up)
//    {
//        int l=0;
//        int r=0;
//        if(l1 != null)
//            l=l1.val;
//        if(l2 != null)
//            r=l2.val;
//        ListNode temp=new ListNode((l+r+up)%10);
//        up=(l+r+up)/10;
//        if(l1==null) {
//            if(l2 == null) {
//                if(temp.val!=0)
//                    return temp;
//                else return null;
//            } else {
//                temp.next=addfun(null,l2.next,up);
//            }
//        }else {
//            if(l2 == null) {
//                temp.next=addfun(l1.next,null,up);
//            } else {
//                temp.next=addfun(l1.next,l2.next,up);
//            }
//        }
//        return temp;
//    }
//}