import jdk.swing.interop.SwingInterOpUtils;

public class Solution28 {
    public static void main(String[] args) {
        String s1="hello";
        String s2=     "ll";
        Solution s=new Solution();
        System.out.println(s.strStr(s1,s2));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack  == null || needle ==null)
            return -1;
        if(needle.length()<=0)
            return 0;
        int index=-1;
        boolean isfind=false;
        char [] chars=needle.toCharArray();
        while (haystack.length()>0 && !isfind )
        {
            System.out.println("haystack "+haystack);
            int temp=0;
            isfind=true;
            if(haystack.indexOf(needle.charAt(0))==-1) {
                index=-1;
                break;
            }
            temp=1+haystack.indexOf(needle.charAt(0));
            index+=temp;
            haystack=haystack.substring(temp);
            System.out.println(haystack);
            if(haystack.length()+1<needle.length()) {
                index=-1;
                break;
            }
            for(int i=1;i<chars.length;i++)
            {
                System.out.println(needle.charAt(i)+" "+haystack.charAt(i-1));
                System.out.println(needle.charAt(i) !=haystack.charAt(i-1));
                if(needle.charAt(i) !=haystack.charAt(i-1))
                    isfind=false;
            }
            System.out.println(isfind);
        }
        return index;
    }
}