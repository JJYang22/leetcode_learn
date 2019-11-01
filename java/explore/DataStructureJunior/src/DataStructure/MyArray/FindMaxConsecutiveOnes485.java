package DataStructure.MyArray;

/**
 * @Author Voidmian
 * @Date 2019/11/1 14:26
 */
public class FindMaxConsecutiveOnes485 {
    static public void test(){
        FindMaxConsecutiveOnes485 findMaxConsecutiveOnes485 = new FindMaxConsecutiveOnes485();
        int [] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes485.findMaxConsecutiveOnes(nums));
    }


    public int findMaxConsecutiveOnes(int[] nums) {
        int index=0;
        int length=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] == 0){
                int temp = i - index;
                if(temp > length){
                    length = temp;
                }
                index=i+1;
            }
        }
        int temp = nums.length - index;
        if(temp > length){
            length = temp;
        }
        return length;
    }
}
