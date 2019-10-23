import java.util.ArrayList;
import java.util.List;

/**
 * @Author Voidmian
 * @Date 2019/10/15 15:54
 */
public class Solution89 {
    public static void main(String[] args) {
        Solution s=new Solution();
        List<Integer> ans=s.grayCode(3);
        for (Integer str:ans
             ) {
            System.out.println(str);
        }
    }
}
class Solution {
    public List<Integer> grayCode(int n) {
        int length=(int) Math.pow(2,n);
        List<Integer> ans =new ArrayList<Integer>(length);
        if(n!=0)
            func(false,0,ans,n);
        else
            ans.add(0);
        return ans;
    }
    private void func(boolean AorB,Integer data,List<Integer> ans,int n) {
        if(0==n)
            ans.add(data);
        else {
            if (!AorB) {
                    func( false, data*2, ans,n-1);
                    func( true, data*2+1, ans,n-1);
            } else {
                    func(false, data*2+1, ans,n-1);
                    func(true, data*2, ans,n-1);
            }
        }
    }
}