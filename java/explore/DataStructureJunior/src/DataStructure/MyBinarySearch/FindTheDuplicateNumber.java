package DataStructure.MyBinarySearch;

/**
 * @Author Voidmian
 * @Date 2019/11/15 16:20
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        fast = nums[nums[fast]];
        slow = nums[slow];
        while (fast != slow){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while (nums[slow] != nums[fast]){
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];
    }
}
