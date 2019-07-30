import java.util.ArrayList;
import java.util.List;

public class Solution315 {
    public  static void main(String args [])
    {
        ArrayList <Integer> nums= new ArrayList<>(4);
        nums.add(5);
        nums.add(2);
        nums.add(6);
        nums.add(1);
        Solution s=new Solution(0,nums);
        List<Integer> ans=s.mergesort(nums);
        System.out.println(s.nixushudui);
        for(Integer a : ans)
        {
            System.out.print(a+" ");
        }
    }
}
class Solution {
    int nixushudui;
    ArrayList <Integer> nums;
    ArrayList <Integer> counts ;
    ArrayList <Integer> indexs ;

   public Solution(int nixu,ArrayList<Integer> nums) {
        nixushudui = nixu;
        indexs = new ArrayList<>(nums.size());
        counts = new ArrayList<>(nums.size());
        this.nums =new ArrayList<>(nums.size());
        for (int i = 0; i < nums.size(); i++)
        {
            indexs.add(i,i);
            this.nums.add(i,nums.get(i));
            counts.add(i,0);
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        indexs = new ArrayList<>(nums.length);
        counts = new ArrayList<>(nums.length);
        this.nums =new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++)
        {
            indexs.add(i,i);
            this.nums.add(i,nums[i]);
            counts.add(i,0);
        }
        mergesort(indexs);
        return counts;
    }
    public List<Integer> mergesort(ArrayList<Integer> nums)
    {
        return merge(nums,0,nums.size()-1);
    }
    public List <Integer> merge(ArrayList<Integer> nums , int begin ,int end)
    {
        if(begin>end)
            return null;
        if(begin == end)
        {
            List<Integer> ans=new ArrayList<Integer>(1);
            ans.add(nums.get(begin));
            return ans;
        }
        int mid=(begin+end)/2;
        List<Integer> left=merge (nums,begin,mid);
        List<Integer> right=merge (nums,mid+1,end);
        List<Integer> ans=new ArrayList<Integer>(end -begin +1);
        int ans_t=0;
        int left_t=0;
        int right_t=0;
        while(ans_t++<end-begin+1)
        {
            if(left_t>mid-begin) {
                ans.add(right.get(right_t++));
                continue;
            }
            if(right_t>end-mid-1) {
                ans.add(left.get(left_t++));
                continue;
            }
            if(left.get(left_t) < right.get(right_t)) {
                ans.add(left.get(left_t++));
            }
                else
            {
                nixushudui=nixushudui+end-mid-right_t;
                ans.add(right.get(right_t++));
            }
        }
        return ans;
    }
}