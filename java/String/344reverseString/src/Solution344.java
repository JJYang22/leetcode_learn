public class Solution344 {
    public static void main(String[] args) {
        char []s={'a', 'c',',','b','a'};
        Solution solution=new Solution();
        solution.reverseString(s);
    }
}
class Solution {
    public void reverseString(char[] s) {
        for (int i=0;i<(s.length)/2;i++)
        {
            System.out.println("test");
            char temp=s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }

        for (char c:s
             ) {
            System.out.println(c);
        }
    }
}