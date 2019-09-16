public class Solution8 {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.myAtoi(" -42-adf"));
    }
}
class Solution {
    public int myAtoi(String str) {
        if(str==null ||str.length()==0)
            return 0;
        int start=0;
        while ( start<str.length()&&str.charAt(start)==' ')
            start++;
        if(start >=str.length() )
            return 0;
        boolean isNegative=false;
        if (str.charAt(start) == '-') {
            isNegative=true;
            start++;
        }else {
        if(str.charAt(start) == '+'){
            start++;
        }}
        if(start >=str.length() )
            return 0;
        if(str.charAt(start)<'0'|| str.charAt(start)>'9')
            return 0;

        int end=start+1;
        while (end<str.length() && str.charAt(end)>='0'&& str.charAt(end)<='9' )
            end++;

        int x=0;
        if (isNegative) {
            for(int i=start;i<end-1;i++) {
                x*=10;
                x-=(str.charAt(i)-'0');
                if(x<Integer.MIN_VALUE/10)
                    return Integer.MIN_VALUE;
            }
            if((x*=10)<(Integer.MIN_VALUE+str.charAt(end-1)-'0'))
                return Integer.MIN_VALUE;
            x-=str.charAt(end-1)-'0';
        }
        else {
            for(int i=start;i<end-1;i++) {

                x*=10;
                x+=(str.charAt(i)-'0');
                if(x>Integer.MAX_VALUE/10)
                    return Integer.MAX_VALUE;
            }
            if((x*=10)>(Integer.MAX_VALUE-str.charAt(end-1)+'0'))
                return Integer.MAX_VALUE;
            x+=str.charAt(end-1)-'0';
        }
        return x;

    }
}