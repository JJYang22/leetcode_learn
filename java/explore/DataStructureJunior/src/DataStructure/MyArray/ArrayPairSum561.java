package DataStructure.MyArray;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author Voidmian
 * @Date 2019/11/1 10:28
 */
public class ArrayPairSum561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for (int i = 0; i <nums.length ; i+=2) {
            ans+=nums[i];
        }
        return ans;
    }
}
