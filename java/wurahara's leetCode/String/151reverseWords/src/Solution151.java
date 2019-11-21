public class Solution151 {
    public static void main(String[] args) {
        Solution s=new Solution();
        String  str="   a   b       ";
        System.out.println(s.reverseWords(str));
    }
}
class Solution {
    public String reverseWords(String s) {
        StringBuilder str=new StringBuilder();
        String [] Strs=s.split(" ");
        for (int i = Strs.length-1; i>=0 ; i--) {
            if (Strs[i].length() > 0) {
                if (str.length() == 0)
                    str.append(Strs[i]);
                else
                    str.append(" "+Strs[i]);
            }
        }
        return str.toString();
    }
}