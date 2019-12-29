package DynamicProgramming;

/**
 * @Author Voidmian
 * @Date 2019/12/26 10:36
 */
public class PerfectSquares279 {
    public static void main(String[] args) {
        PerfectSquares279 perfectSquares279 = new PerfectSquares279();
        System.out.println(perfectSquares279.numSquares(8));
    }
    public int numSquares(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i;
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 1; j * j <= i; j++) {
                ans[i] = Math.min(ans[i], ans[i - j * j] + 1);
            }
        }
        return ans[n];
    }
}
