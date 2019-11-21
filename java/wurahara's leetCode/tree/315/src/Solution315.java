import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution315 {
    public  static void main(String args [])
    {
//        ArrayList <Integer> nums= new ArrayList<>(4);
//        nums.add(5);
//        nums.add(2);
//        nums.add(6);
//        nums.add(1);
        int nums [] ={-1,-1} ;
        Solution s=new Solution();
       List <Integer> ans=s.countSmaller(nums);
        for(Integer a : ans)
        {
            System.out.print(a+" ");
        }
    }
}
class Solution {

   int [] counts ;
   int [] indexs ;
    public List<Integer> countSmaller(int[] nums) {
        if(nums  == null )
            return null;
        indexs = new int [nums.length];
        counts = new int [nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            indexs[i]=i;
            counts[i]=0;
        }
        mergesort(nums);
        List<Integer>ans =new LinkedList<Integer>();
        for (int i:counts)
        {
            ans.add(i);
        }
        return ans;
    }
    public void mergesort(int nums[])
    {
         merge(0,indexs.length-1,nums);
    }
    public void merge( int begin ,int end,int nums[])
    {
        if(begin>=end)
            return ;
        int mid=(begin+end)/2;
        merge (begin,mid,nums);
        merge (mid+1,end,nums);
        if(nums[indexs[mid]] > nums[indexs[mid+1]]) {
           int[] ans = new int[end - begin + 1];
           int ans_t = 0;
           int left_t = 0;
           int right_t = 0;
           while (ans_t < end - begin + 1) {
               if (left_t > mid - begin) {
                   ans[ans_t] = indexs[mid + 1 + right_t++];
                   ans_t++;
                   continue;
               }
               if (right_t > end - mid - 1) {
                   ans[ans_t] = indexs[begin + left_t++];
                   ans_t++;
                   continue;
               }
               if (nums[indexs[begin + left_t]] <= nums[indexs[mid + 1 + right_t]]) {
                   ans[ans_t] = indexs[begin + left_t++];
               } else {
                   for (int i = left_t; i <= mid - begin; i++) {
                       this.counts[indexs[begin + i]] = counts[indexs[begin + i]] + 1;
                   }
                   ans[ans_t] = indexs[mid + 1 + right_t++];
               }
               ans_t++;
           }
           for (int i = 0; i <= end - begin; i++) {
               indexs[begin + i] = ans[i];
           }
       }
        return ;
    }
}