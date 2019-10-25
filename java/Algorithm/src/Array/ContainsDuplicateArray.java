package Array;

import org.w3c.dom.CDATASection;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Voidmian
 * @Date 2019/10/23 16:10
 */
public class ContainsDuplicateArray {
    static public void test(){
        ContainsDuplicateArray containsDuplicateArray=new ContainsDuplicateArray();
        int [] nums={1,2,3,4,5,6,7,8};
        System.out.println(containsDuplicateArray.containsDuplicate(nums));
    }
    public boolean containsDuplicate(int[] nums) {

        Map<Integer,Integer> map=new HashMap<>();

        for (int num :nums
        ) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }
}
