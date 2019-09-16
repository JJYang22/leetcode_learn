import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution76{
    public static void main(String[] args) {
        String S="ADOBECODEBANC";
        String T="ABC";
        Solution s=new Solution();
        System.out.println("lastans="+s.minWindow(S,T));
    }
}

class Solution {
    public String minWindow(String s, String s1) {
        if(s1 == null || s1.length()==0 )
            return "";
        if(s == null || s1.length()>s.length())
            return "";
        StringBuilder s2=new StringBuilder();
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i <s.length() ; i++) {
            if(s1.contains(Character.toString(s.charAt(i))))
            {
                s2.append(s.charAt(i));
                list.add(i);
            }
        }

        //s2为整理后s,s1为查询字符串
        if(s2 == null || s1.length()>s2.length())
            return "";

        Map<Character ,Integer> map=new HashMap();

        for (int i = 0; i <s1.length() ; i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0)+1);
        }
        int ans_length=Integer.MAX_VALUE;
        int ans_left=0;
        int ans_right=0;
        int temp=0;
        int left=0;
        int right=s1.length();
        for (int i = 0; i <s1.length() ; i++) {
            map.put(s2.charAt(i), map.get(s2.charAt(i))-1);
        }
        while (!IsSatisfy(map) && right<s2.length()) {
            map.put(s2.charAt(right), map.get(s2.charAt(right))-1);
            right++;
        }
        if(!IsSatisfy(map))
            return "";
        while (right<=s2.length() && ans_length!=s1.length()) {
            while (map.get(s2.charAt(left))<0) {
                map.put(s2.charAt(left), map.get(s2.charAt(left))+1);
                left++;
            }
            temp=list.get(right-1)-list.get(left)+1;
            if(temp<ans_length) {
                ans_left=list.get(left);
                ans_right=list.get(right-1);
                ans_length=temp;
            }
            if(right==s2.length())
                break;
            map.put(s2.charAt(right), map.get(s2.charAt(right))-1);
            right++;
        }
        return s.substring(ans_left,ans_right+1);
    }
    boolean IsSatisfy ( Map<Character ,Integer> map)
    {
        for (Integer i:map.values()) {
            if(i>0)
                return false;
        }
        return true;
    }
}
