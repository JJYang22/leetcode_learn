package DataStructure.MyArray;

import java.util.Random;

/**
 * @Author Voidmian
 * @Date 2019/11/1 14:20
 */
public class RemoveElement27 {
    static public void test(){
        RemoveElement27 removeElement27=new RemoveElement27();
    }
    public int removeElement(int[] nums, int val) {
        int length = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[index]=nums[i];
                index++;
            }else {
                length++;
            }
        }
        return nums.length-length;
    }
}
