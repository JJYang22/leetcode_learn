package DataStructure.MyBinarySearchTree;

import DataStructure.Obj.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyAlmostDuplicate220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k < 1 || t < 0)
            return false;
        Map<Long, Long> map = new HashMap<>();
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            Long temp;
            if (nums[i] < 0) {
                temp = ((long) nums[i] + 1) / ((long) t + 1) - 1;
            } else
                temp = (long) nums[i] / ((long) t + 1);

        }
        return false;
    }

    private

}
