package DataStructure.MyHashSet;

/**
 * @Author Voidmian
 * @Date 2019/11/6 19:46
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int ans=0;
        for (int i = 0; i < nums.length ; i++) {
            ans^=nums[i];
        }
        return ans;
    }
}
