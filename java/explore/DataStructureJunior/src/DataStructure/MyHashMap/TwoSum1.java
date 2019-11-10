package DataStructure.MyHashMap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Voidmian
 * @Date 2019/11/7 17:41
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],i);
        }
        int[] ans=new int[2];
        for (int i = 0; i <nums.length ; i++) {
            if(map.containsKey(target-nums[i])){
                ans[0]=i;
                ans[1]=map.get(target-nums[i]);
                if(ans[1]!=ans[0])
                    return ans;
            }
        }
        ans[0]=-1;
        ans[1]=-1;
        return ans;
    }
}
