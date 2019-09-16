public class Solution371 {
    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println( s.getSum(6, 6));
}
}

class Solution {
    public int getSum(int a, int b) {
        int ans=a^b;
        int up=a&b;
        while (up!=0)
        {
            int temp=up<<1;
            up=ans&temp;
            ans=ans^temp;
        }
        return ans;
    }
}