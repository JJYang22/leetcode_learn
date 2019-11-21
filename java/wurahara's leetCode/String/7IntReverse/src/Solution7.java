public class Solution7 {
    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.reverse(1534236469));
    }
}
class Solution {
    public int reverse(int x) {
        boolean IsNegative=false;
        if(x<0){
            if(x==Integer.MIN_VALUE)
                return 0;
            IsNegative=true;
            x=-x;
        }
        char [] chars=Integer.toString(x).toCharArray();
        x=0;
        for (int i = chars.length-1; i >0 ; i--) {
            x*=10;
            x+=chars[i]-'0';
            if(x>Integer.MAX_VALUE/10)
                return 0;
        }
        if((x*=10)> (Integer.MAX_VALUE-chars[0]+'0'))
        {
            return 0;
        }
        x+=chars[0]-'0';
        if(IsNegative)
            x=-x;
        return x;
    }
}