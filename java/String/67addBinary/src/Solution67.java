import java.util.Arrays;

public class Solution67 {
    public static void main(String[] args) {
        String s1 = new String("111");
        String s2 = new String("11");
        Solution s = new Solution();
        System.out.println(s.addBinary(s1, s2));
    }
    }


class Solution {
    public String addBinary(String a, String b) {
        char [] as=a.toCharArray();
        char [] bs=b.toCharArray();
        int length = as.length>bs.length?as.length:bs.length;
        char [] ans=new char [length+1];
        for(int i=0;i<=length;i++)
            ans[i]='0';
        for(int i=length; i>0;i--)
        {
            int temp=0;
            if((length-i)<as.length)
                temp+=as[as.length-1+i-length]-'0';
            if((length-i)<bs.length)
                temp+=bs[bs.length-1+i-length]-'0';
            temp+=ans[i]-'0';
            switch (temp)
            {
                case 1:{
                    ans[i]='1';
                    break;
                }
                case 2:{
                    ans[i]='0';
                    ans[i-1]='1';
                    break;
                }
                case 3:{
                    ans[i]='1';
                    ans[i-1]='1';
                    break;
                }
                default:
            }
        }
        if(ans[0]=='0')
            return (new String(ans)).substring(1);
        else
            return new String(ans);
    }

}