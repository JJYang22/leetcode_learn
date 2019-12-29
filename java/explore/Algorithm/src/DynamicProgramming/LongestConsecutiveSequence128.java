package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Voidmian
 * @Date 2019/12/23 21:33
 */
public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        LongestConsecutiveSequence128 longestConsecutiveSequence128 = new LongestConsecutiveSequence128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSequence128.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        Set<Integer> fun = new HashSet<>();
        for (int n : nums
        ) {
            fun.add(n);
        }
        int ans = 0;
        for (int f : fun) {
            if (!fun.contains(f - 1)) {
                int cur = f;
                int length = 1;
                cur = f + 1;
                while (fun.contains(cur)) {
                    cur = cur + 1;
                    length++;
                }
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }
}
