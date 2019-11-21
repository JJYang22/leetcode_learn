import java.util.*;
import java.util.stream.Collectors;

public class Solution22 {
    public static void main(String[] args) {
        Solution s=new Solution();
        List<String>ans=s.generateParenthesis(3);

        System.out.println();
        for (String str:ans
             ) {
            System.out.println(str);
        }
    }
}


class Solution {

    public List<String> generateParenthesis(int n) {
        List <String> ans = new ArrayList();
        backtracking(ans,0,0,"",n);
        return ans;
    }
    private void backtracking(List ans,int left,int right,String str,int max) {
        if(str.length()==max*2){
            ans.add(str);
        }
        else {
            if(left>right &&right<max)
                backtracking(ans,left,right+1,str+")",max);
            if(left<max)
                backtracking(ans,left+1,right,str+"(",max);
        }
    }
}