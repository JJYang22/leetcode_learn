package DataStructure.MyBinarySearch;

/**
 * @Author Voidmian
 * @Date 2019/11/14 21:46
 */
public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if (nums == null || nums.length == 0)
            return ans;
        int left = 0, right = nums.length - 1;
        int mid = left + (right - left) / 2;
        int index = -1;
        while (left <= right) {
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        if (index == -1)
            return ans;
        int temp = 0;
        while (index - 1 - temp >= 0 && nums[index - 1 - temp] == nums[index]) {
            temp++;
        }
        ans[0] = index - temp;
        temp = 0;
        while (nums.length > index + 1 + temp && nums[index + 1 + temp] == nums[index]) {
            temp++;
        }
        ans[1] = index + temp;
        return ans;
    }
}
