package Array;

/**
 * @Author Voidmian
 * @Date 2019/10/25 10:29
 */
public class MoveZeroes {
    static public void test(){
        int [] nums={1,2,3,4,5,6,7,8};
        int k=3;
        RotateArray rotateArray=new RotateArray();
        rotateArray.rotateByReverse(nums,k);
        for (int num:nums
        ) {
            System.out.println(num);
        }
    }

    public void moveZeroes(int[] nums) {

    }
}
