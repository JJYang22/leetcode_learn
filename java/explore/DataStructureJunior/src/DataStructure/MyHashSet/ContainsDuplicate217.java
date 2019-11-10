package DataStructure.MyHashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Voidmian
 * @Date 2019/11/5 20:38
 */
public class ContainsDuplicate217 {
    static public void test(){
        int [] nums={1,2,3,1};
        ContainsDuplicate217 containsDuplicate217 = new ContainsDuplicate217();
        boolean ans=containsDuplicate217.containsDuplicate(nums);
        System.out.println(ans);
    }
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length ; i++) {
            if(set.contains((Integer) nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
