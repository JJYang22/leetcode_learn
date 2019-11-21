public class Solution8 {
    public static void main(String [] args)
    {
    String str="    -91283472332342342342342342334fdfg423424323423423423423423423432+";
    Solution s=new Solution() ;
    System.out.println(s.myAtoi(str));
    }
}
class Solution
{
    boolean isoverflow =false;
    public int myAtoi(String str)
    {
        long ans=0;
        if(str ==null || str.length() == 0 )
            return 0;
        int start=0;
        for (;start<str.length();start++)
        {
            if(str.charAt(start)!=' ')
                break;
        }
        if(start == str.length())
            return 0;
        if(str.charAt(start) == '-'&&str.length()>start+1 &&str.charAt(start+1) >='0' &&str.charAt(start+1) <='9' )
        {
            ans = -1 * myatoi(str.substring(start + 1));
            if(isoverflow)
                ans-=1;
        }
        if(str.charAt(start) == '+'&&str.length()>start+1 &&str.charAt(start+1) >='0' &&str.charAt(start+1) <='9')
            ans= myatoi(str.substring(start+1));
        if(str.charAt(start) >='0' &&str.charAt(start) <='9')
            ans= myatoi(str.substring(start));


        return (int)ans;
    }
    private  long myatoi(String str)
    {
        int end=0;
        for(;end<str.length();end++)
        {
            if(str.charAt(end)>'9' || str.charAt(end)<'0')
                break;
        }
        return change(str.substring(0,end),end-1);
    }
    private long change(String str ,int end)
    {
        long ans=0;
        if(end >0)
            ans= (long)(str.charAt(end)-'0')+10*change(str.substring(0,end),end-1);
        else
            ans= (long)(str.charAt(end)-'0');
        if(ans>(1<<31)-1) {
            isoverflow = true;
            ans=(1<<31)-1;
        }
        return ans;

    }
}