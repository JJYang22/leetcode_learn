package DataStructure.MyHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Voidmian
 * @Date 2019/11/10 10:07
 */
public class TopKFrequentElements347 {
    static public void test(){
        TopKFrequentElements347 topKFrequentElements347 = new TopKFrequentElements347();
        int [] nums = {1,1,-4,-4,-4,-4,1,0,0,0,2,2,3};
        topKFrequentElements347.topKFrequent(nums,3);
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        Map<Integer, Integer> stat = new HashMap<>();
        for (int num : nums) {
            stat.put(num, stat.getOrDefault(num, 0) + 1);
        }
        List<Integer> keys = stat.keySet().stream().collect(Collectors.toList());
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Integer max = null;
            for (Integer key : keys) {
                if (stat.get(key) > stat.getOrDefault(max, Integer.MIN_VALUE)) {
                    max = key;
                }
            }
            keys.remove(max);
            ans.add(max);
        }
        return ans;
    }
}
