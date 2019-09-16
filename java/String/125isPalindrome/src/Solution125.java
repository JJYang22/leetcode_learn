public class Solution125 {
    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.isPalindrome(".,"));
    }
}
class Solution {
    public boolean isPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        while (start<end)
        {
            while (start<end&&!((s.charAt(start)>='0' && s.charAt(start)<='9') ||(s.charAt(start)>='a' && s.charAt(start)<='z')||(s.charAt(start)>='A' && s.charAt(start)<='Z') ))
                start++;
            while (start<end&&!((s.charAt(end)>='0' && s.charAt(end)<='9') ||(s.charAt(end)>='a' && s.charAt(end)<='z')||(s.charAt(end)>='A' && s.charAt(end)<='Z') ))
                end--;
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
                continue;
            }
            if(s.charAt(start)>='a' && s.charAt(start)<='z') {
                if(s.charAt(start)-32 == s.charAt(end)) {
                    start++;
                    end--;
                    continue;
                }
            }
            if(s.charAt(start)>='A' && s.charAt(start)<='Z') {
                if(s.charAt(start)+32 == s.charAt(end)) {
                    start++;
                    end--;
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}