package Array;

/**
 * @Author Voidmian
 * @Date 2019/10/23 16:34
 */
public class SingleNumberInArray {
    static public void test(){
        SingleNumberInArray singleNumberInArray=new SingleNumberInArray();
        int [] nums={2,2,3,1,2,3,1};
        System.out.println(singleNumberInArray.singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        int temp=0;
        for (int num:nums
             ) {
            temp=temp^num;
        }
        return temp;
    }
}
