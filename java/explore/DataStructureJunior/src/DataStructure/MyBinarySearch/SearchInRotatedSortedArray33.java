package DataStructure.MyBinarySearch;

/**
 * @Author Voidmian
 * @Date 2019/11/12 18:13
 */
public class SearchInRotatedSortedArray33 {
    static public void test() {
        SearchInRotatedSortedArray33 searchInRotatedSortedArray33 = new SearchInRotatedSortedArray33();
        int[] nums = {3, 1};
        System.out.println(searchInRotatedSortedArray33.search(nums, 1));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int index = (begin + end) / 2;
            if (nums[index] == target) {
                return index;
            }
            if (nums[begin] <= nums[index]){
                if(nums[index] >= target && nums[begin] <= target) {
                    end = index -1;
                } else {
                    begin = index + 1;
                }
            } else {
                if(nums[index] <= target && nums[end] >= target){
                    begin = index + 1;
                } else {
                    end = index -1;
                }
            }
        }

        return -1;
        //   return binaryRotatedSearch(nums, 0, nums.length - 1, target);
    }

    private int binaryRotatedSearch(int[] nums, int begin, int end, int target) {
        if (begin > end)
            return -1;
        int index = (begin + end) / 2;
        if (nums[index] == target) {
            return index;
        }
        if ((index - 1) >= begin && nums[begin] <= nums[index - 1]) {
            if (nums[index - 1] >= target && nums[begin] <= target) {
                return binarySearch(nums, begin, index - 1, target);
            } else {
                return binaryRotatedSearch(nums, index + 1, end, target);
            }
        }
        if ((index + 1) <= end && nums[index + 1] <= nums[end]) {
            if (nums[index + 1] <= target && nums[end] >= target) {
                return binarySearch(nums, index + 1, end, target);
            } else {
                return binaryRotatedSearch(nums, begin, index - 1, target);
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int begin, int end, int target) {
        if (begin > end)
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
