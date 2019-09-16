public class Solution557 {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.reverseWords("ac    ba"));
    }
}

class Solution {
    public String reverseWords(String s) {
        StringBuilder SB=new StringBuilder();
        String [] ss=s.split(" ");

        for (String str:ss
             ) {

            str=new StringBuilder(str).reverse().toString();
            SB.append(str+" ");
        }

        return SB.delete(SB.length()-1,SB.length()).toString();
    }
}