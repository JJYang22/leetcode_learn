package DataStructure.MyBinarySearch;

/**
 * @Author Voidmian
 * @Date 2019/11/14 20:35
 */
public class FindMinimumInRotatedSortedArrayII154 {
    static public void test() {
        FindMinimumInRotatedSortedArrayII154 findMinimumInRotatedSortedArrayII154 = new FindMinimumInRotatedSortedArrayII154();
        int[] nums = {10, 10, 10, 11, 10};
        System.out.println(findMinimumInRotatedSortedArrayII154.findMin(nums));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == -1)
            return -1;
        int begin = 0;
        int end = nums.length - 2;
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

//网上题解
//        if (nums == null || nums.length == -1)
//            return -1;
//        long begin = 0;
//        long end = nums.length - 1;
//        int index = (int) ((begin + end) / 2);
//        if(nums[(int)end] > nums[0])
//            return nums[0];
//        while (begin <= end) {
//            if(nums[(int)end] > nums[(int)begin])
//                return nums[(int)begin];
//            if(begin == end)
//                return nums[index];
//            if(nums[index] < nums[(index - 1 + nums.length)%nums.length])
//                return nums[index];
//            if(nums[0] > nums[index]){
//                end = index - 1;
//            } else if (nums[0] < nums[index]) {
//                begin = index + 1;
//            } else {
//                begin = begin + 1;
//            }
//            index = (int) ((begin + end) / 2);
//        }
//        return -1;
//自己解法
//        if (nums == null || nums.length == -1)
//            return -1;
//        long begin = 0;
//        long end = nums.length - 1;
//        int index = (int) ((begin + end) / 2);
//        if (nums[(int) end] > nums[0])
//            return nums[0];
//        while (begin <= end) {
//            if (begin == end)
//                return nums[index];
//            int temp = 0;
//            while (index - temp > begin && nums[index] == nums[index - temp]) {
//                temp++;
//            }
//            if(index != begin)
//                temp --;
//            if (nums[index - temp] < nums[(index -temp - 1 + nums.length) % nums.length])
//                return nums[index];
//            temp = 0;
//            while (index - temp > begin && nums[index] == nums[index - temp]) {
//                temp++;
//            }
//            if (nums[0] > nums[index - temp]) {
//                end = index - 1;
//            } else {
//                begin = index + 1;
//            }
//            index = (int) ((begin + end) / 2);
//        }
//        return -1;
    }

}
