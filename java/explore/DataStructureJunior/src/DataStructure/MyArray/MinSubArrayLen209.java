package DataStructure.MyArray;

/**
 * @Author Voidmian
 * @Date 2019/11/1 14:36
 */
public class MinSubArrayLen209 {
    static public void test() {
        MinSubArrayLen209 minSubArrayLen209 = new MinSubArrayLen209();
        int[] nums = {2, 3, 2, 1, 4,3};
        System.out.println(minSubArrayLen209.minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int minLength = nums.length + 1;
        int begin = 0, end = 0;
        int sum=0;
        while (end<nums.length){
            sum+=nums[end];
            while (sum>=s){
                int length = end-begin+1;
                if(minLength>length){
                    minLength=length;
                }
                sum-=nums[begin];
                begin++;
            }
            end++;
        }
        if(minLength == nums.length+1)
            return 0;
        return minLength;
    }

}
