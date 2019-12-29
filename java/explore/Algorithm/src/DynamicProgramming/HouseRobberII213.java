package DynamicProgramming;

/**
 * @Author Voidmian
 * @Date 2019/12/25 11:28
 */
public class HouseRobberII213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int length = nums.length - 1;
        int[] ans1 = new int[length];
        int[] ans2 = new int[length];
        ans1[0] = nums[0];
        ans2[0] = nums[1];
        for (int i = 1; i < length; i++) {
            if (i == 1) {
                ans1[i] = Math.max(nums[1], nums[0]);
                ans2[i] = Math.max(nums[2], nums[1]);
            } else {
                ans1[i] = Math.max(nums[i] + ans1[i - 2], ans1[i - 1]);
                ans2[i] = Math.max(nums[i + 1] + ans2[i - 2], ans2[i - 1]);
            }
        }
        return Math.max(ans1[length - 1],ans2[length - 1]);
    }
}
