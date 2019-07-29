import java.util.ArrayList;
import java.util.List;

public class Solution315 {
    public  static void main(String args [])
    {
        int nums[]={5,2,6,1};
        Solution s=new Solution();
    }
}
class Solution {
    public List<Integer> countSmaller(int[] nums) {
      return null;
    }
    public List<Integer> mergesort(int [] nums)
    {
        return merge(nums,0,nums.length-1);
    }
    public List <Integer> merge(int [] nums, int begin ,int end)
    {
        if(begin>end)
            return null;
        if(begin == end)
        {
            List<Integer> ans=new ArrayList<Integer>(1);
            ans.add(nums[begin]);
            return ans;
        }
        int mid=(begin+end)/2;
        List<Integer> left=merge (nums,begin,mid);
        List<Integer> right=merge (nums,mid+1,end);
        List<Integer> ans=new ArrayList<Integer>(end -begin +1);
        if (right == null)
            return left;
        int ans_t=0;
        int left_t=0;
        int right_t=0;
        while(ans_t<end-begin+1)
        {
            if(left.get(left_t) < right.get())
        }
    }
}