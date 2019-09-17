import java.util.Stack;

public class Solution739 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int []input={73,74,75,71,69,72,76,73};
        int [] ans=s.dailyTemperatures(input);
        for (int i:ans
             ) {
            System.out.print(i+" ");
        }
    }
}
////逆序
//class Solution {
//    public int[] dailyTemperatures(int[] T) {
//        if(T==null || T.length==0)
//            return null;
//        int []ans=new int[T.length];
//        Stack<Integer> days=new Stack<>();
//        for (int i=T.length-1;i>=0;i--) {
//            while (!days.isEmpty()&&T[i]>=T[days.peek()]) {
//               days.pop();
//            }
//            if(!days.isEmpty())
//                ans[i]=days.peek()-i;
//            days.push(i);
//        }
//        return ans;
//    }
//}
//正序
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T==null || T.length==0)
            return null;
        int []ans=new int[T.length];
        Stack<Integer> days=new Stack<>();
        days.push(0);
        for (int i=1;i<T.length;i++) {
            int temp=1;
            while (!days.isEmpty()&&T[i]>T[days.peek()]) {
                ans[days.peek()]=i-days.pop();
            }
            days.push(i);
        }
        return ans;
    }
}