public class Solution38 {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.countAndSay(5));
    }
}
class Solution {
    public String countAndSay(int n) {
        String str= "1";
        return fun(str,n,1);
    }
    public String fun(String str,int n,int temp)
    {
        if(temp == n)
            return str;
        int count=0;
        StringBuilder strb=new StringBuilder();
        for(int j=0;j<str.length()-1;j++)
        {
            if(str.charAt(j)==str.charAt(j+1))
                count++;
            else
            {
                strb.append(++count);
                strb.append(str.charAt(j));
                count=0;
            }
        }
        if(count==0)
        {
            strb.append(1);
            strb.append(str.charAt(str.length()-1));
        }
        else
        {
            strb.append(++count);
            strb.append(str.charAt(str.length()-1));
        }
        return fun(strb.toString(),n,temp+1);
    }
}