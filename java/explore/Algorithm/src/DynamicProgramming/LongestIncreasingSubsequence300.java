package DynamicProgramming;

import java.util.Arrays;

/**
 * @Author Voidmian
 * @Date 2019/12/26 10:59
 */
public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        LongestIncreasingSubsequence300 longestIncreasingSubsequence300 = new LongestIncreasingSubsequence300();
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(longestIncreasingSubsequence300.lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    ans[i] = Math.max(ans[i], ans[j] + 1);
            }
            max = Math.max(max, ans[i]);
        }
        return max;
    }
}
