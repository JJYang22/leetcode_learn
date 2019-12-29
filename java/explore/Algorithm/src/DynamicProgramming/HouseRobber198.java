package DynamicProgramming;

import java.util.Objects;

/**
 * @Author Voidmian
 * @Date 2019/12/25 10:54
 */
public class HouseRobber198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                ans[i] = Math.max(nums[1], nums[0]);
            } else {
                ans[i] = Math.max(nums[i] + ans[i - 2], ans[i - 1]);
            }
        }
        return ans[ans.length - 1];
    }
}
