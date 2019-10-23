package Array;

/**
 * @Author Voidmian
 * @Date 2019/10/23 15:47
 */
public class ReverseArray {


    static public void reverseIntArray(int[] nums,int begin,int end){
        for (int i = 0; i <(end-begin)/2  ; i++) {
            int temp = nums[i+begin];
            nums[i+begin] = nums[end - 1 - i];
            nums[end - 1 - i] = temp;
        }
    }

}
