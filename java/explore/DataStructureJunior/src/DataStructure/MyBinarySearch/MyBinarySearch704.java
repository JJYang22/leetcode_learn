package DataStructure.MyBinarySearch;

/**
 * @Author Voidmian
 * @Date 2019/11/12 16:55
 */
public class MyBinarySearch704 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int begin, int end, int target) {
        if(begin > end)
            return -1;
        int index = (begin + end) / 2;
        if (nums[index] == target) {
            return index;
        }
        if (nums[index] < target) {
            return binarySearch(nums, index + 1, end, target);
        } else {
            return binarySearch(nums, begin, index - 1, target);
        }
    }
}
