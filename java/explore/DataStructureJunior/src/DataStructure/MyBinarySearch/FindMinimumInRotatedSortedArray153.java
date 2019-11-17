package DataStructure.MyBinarySearch;

/**
 * @Author Voidmian
 * @Date 2019/11/14 15:14
 */
public class FindMinimumInRotatedSortedArray153 {
    static public void test() {
        FindMinimumInRotatedSortedArray153 findMinimumInRotatedSortedArray153 = new FindMinimumInRotatedSortedArray153();
        int[] nums = {2,3,4,5,1};
        System.out.println(findMinimumInRotatedSortedArray153.findMin(nums));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == -1)
            return -1;
        int begin = 0;
        int end = nums.length - 1;
        int mid = begin + (end - begin) / 2;
        while (begin < end) {
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if(nums[mid] > nums[end]){
                begin = mid + 1;
            } else {
                end = mid;
            }
            mid = begin + (end - begin) / 2;
        }
        if (nums[mid] > nums[mid + 1])
            return nums[mid + 1];
        if(nums[mid + 1] > nums[(mid + 2)%nums.length])
            return nums[(mid + 2)%nums.length];
        return -1;
//        if (nums == null || nums.length == -1)
//            return -1;
//        long begin = 0;
//        long end = nums.length - 1;
//        int index = (int) ((begin + end) / 2);
//        if(nums[(int)end] > nums[0])
//            return nums[0];
//        while (begin <= end) {
//
//            if(nums[index] <= nums[(index - 1 + nums.length)%nums.length])
//                return nums[index];
//            if(nums[0] > nums[index]){
//                end = index - 1;
//            } else {
//                begin = index + 1;
//            }
//            index = (int) ((begin + end) / 2);
//        }
//        return -1;
    }

}
