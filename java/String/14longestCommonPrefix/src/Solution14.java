public class Solution14 {
    public static void main(String[] args) {
        String [] strs={"flower","flow","flight"};
        Solution s=new Solution();
        System.out.println(s.longestCommonPrefix(strs));
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null ||strs.length<=0)
            return "";
        String temp=strs[0];
        for (int i = 1; i <strs.length ; i++) {
            int end =0;
            while (end <temp.length()&&end<strs[i].length())
            {
                if(strs[i].charAt(end) != temp.charAt(end))
                    break;
                end++;
            }
            temp=temp.substring(0,end);
        }
        return temp;
    }
}