package DataStructure.MyHashSet;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Voidmian
 * @Date 2019/11/5 21:12
 */
public class ContainsNearbyAlmostDuplicate220 {
    static public void test() {
        int[] nums = {-1,2147483647};
        ContainsNearbyAlmostDuplicate220 containsNearbyAlmostDuplicate220 = new ContainsNearbyAlmostDuplicate220();
        boolean ans = containsNearbyAlmostDuplicate220.containsNearbyAlmostDuplicate(nums, 1, 2147483647);
        System.out.println(ans);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k < 1 || t < 0)
            return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            Long temp ;
            if(nums[i]<0){
                temp = ((long)nums[i]+1)/((long) t+1) -1;
            }else
                temp =(long) nums[i] / ((long)t + 1);
            if(map.containsKey(temp)){
                return true;
            }
            if(map.containsKey(temp+1) && Math.abs(map.get(temp+1)-(long)nums[i])<=t){
                return true;
            }
            if(map.containsKey(temp-1) && Math.abs(map.get(temp-1)-(long)nums[i])<=t){
                return true;
            }
            map.put(temp,(long)nums[i]);
            if(map.size()>=k+1)
                map.remove((long)nums[i-k]/ ((long)t + 1));
        }
        return false;
    }
}
