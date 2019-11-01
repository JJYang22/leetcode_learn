package DataStructure.MyArray;

/**
 * @Author Voidmian
 * @Date 2019/11/1 19:59
 */
public class MoveZeroes283 {
    static public void test() {
        MoveZeroes283 moveZeroes283 = new MoveZeroes283();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes283.moveZeroes(nums);
        System.out.println("finished");
    }

    public void moveZeroes(int[] nums) {
       int index=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=0){
                nums[index]=nums[i];
                index++;
            }
        }
        for(int i=index;i<nums.length;i++){
            nums[i]=0;
        }
    }

    public void rotateArray(int[] nums, int begin, int end, int distance) {
        reverseArray(nums,begin,end);
        reverseArray(nums,begin,begin+distance-1);
        reverseArray(nums,begin+distance,end);

    }


    public void reverseArray(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = temp;
        }
    }
}
