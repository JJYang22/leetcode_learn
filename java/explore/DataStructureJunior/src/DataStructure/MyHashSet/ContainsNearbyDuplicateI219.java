package DataStructure.MyHashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Voidmian
 * @Date 2019/11/5 20:48
 */
public class ContainsNearbyDuplicateI219 {
    static public void test(){
        int [] nums={4,1,2,3,1,5};
        ContainsNearbyDuplicateI219 containsNearbyDuplicateI219 = new ContainsNearbyDuplicateI219();
        boolean ans=containsNearbyDuplicateI219.containsNearbyDuplicate(nums,3);
        System.out.println(ans);
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length<=1 || k<1)
            return false;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if(map.containsKey(nums[i])){
                if(k>=i-map.get(nums[i]))
                    return true;
                else
                    map.put(nums[i],i);
            }else {
                map.put(nums[i],i);
            }
        }
        return false;
//        Set<Integer> used = new HashSet<>();
//        int i=0;
//        for (; i <= k ; i++) {
//            if(i>=nums.length)
//                return false;
//            if(used.contains(nums[i])){
//                return true;
//            }else {
//                used.add(nums[i]);
//            }
//        }
//        while (i<nums.length){
//            used.remove(nums[i-k-1]);
//            if(used.contains(nums[i])){
//                return true;
//            }else {
//                used.add(nums[i]);
//            }
//            i++;
//        }
//        return false;
    }
}
