package DataStructure.MyHashSet;

/**
 * @Author Voidmian
 * @Date 2019/11/7 14:52
 */
public class SingleNumberIII260 {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int num:nums
             ) {
            temp^= num;
        }
        int mask = temp&(-temp);
        int []ans = new int [2];
        for (int num:nums
        ) {
            if((num&mask) == 0){
                ans[0]^=num;
            }else
                ans[1]^=num;
        }
        return ans;
    }
}
