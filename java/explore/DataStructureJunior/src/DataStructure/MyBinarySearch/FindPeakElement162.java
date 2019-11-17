package DataStructure.MyBinarySearch;

/**
 * @Author Voidmian
 * @Date 2019/11/14 14:20
 */
public class FindPeakElement162 {
    static public void test() {
        FindPeakElement162 findPeakElement162 = new FindPeakElement162();
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement162.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {

        if (nums == null || nums.length == 0)
            return -1;
        int begin = 0;
        int end = nums.length - 1;
        int index = begin + (end - begin) / 2;
        while (begin + 1 < end) {
            if (nums[index] > nums[index + 1] && nums[index] > nums[index - 1]) {
                return index;
            }
            if (nums[index + 1] > nums[index]) {
                begin = index;
            } else {
                end = index;
            }
            index = begin + (end - begin) / 2;
        }
        if (nums[end] > nums[begin]) {
            if (end + 1 < nums.length) {
                if(nums[end]>nums[end+1]){
                    return end;
                }
            } else {
                return end;
            }
        }
        return index;


//        if (nums == null || nums.length == -1)
//            return -1;
//        int begin = 0;
//        int end = nums.length - 1;
//        int index = (begin + end) / 2;
//        while (begin <= end) {
//            if (begin == end)
//                return begin;
//            if (index - 1 < begin) {
//                if (nums[index] > nums[index + 1]) {
//                    return index;
//                } else {
//                    begin = index + 1;
//                }
//            } else if (index + 1 > end) {
//                if (nums[index] > nums[index - 1]) {
//                    return index;
//                } else {
//                    end = index - 1;
//                }
//            } else {
//                if (nums[index] > nums[index + 1] && nums[index] > nums[index - 1]) {
//                    return index;
//                }
//                if (nums[index] < nums[index + 1]) {
//                    begin = index + 1;
//                } else {
//                    end = index - 1;
//                }
//            }
//            index = (begin + end) / 2;
//        }
//        return -1;
    }
}
