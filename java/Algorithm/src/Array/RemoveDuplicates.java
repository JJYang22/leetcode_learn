package Array;

/**
 * @Author Voidmian
 * @Date 2019/10/15 19:05
 */

public class RemoveDuplicates {
    static public void test(){
        RemoveDuplicates s = new RemoveDuplicates();
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = s.removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        int len=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=nums[len]){
                len++;
                nums[len]=nums[i];
            }
        }
        return len+1;
    }


}