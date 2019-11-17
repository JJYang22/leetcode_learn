package DataStructure.MyBinarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Voidmian
 * @Date 2019/11/15 21:43
 */
public class FindKthSmallestPairDistance719 {
    static public void test() {
        FindKthSmallestPairDistance719 findKthSmallestPairDistance719 = new FindKthSmallestPairDistance719();
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int begin = 0;
        int end = nums[nums.length - 1] - nums[0];
        while (begin < end) {
            int index = begin + (end - begin) / 2;
            int count = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                while (nums[right] - nums[left] > index){
                    left ++;
                }
                count += right - left;
            }
            if(count <= k)
                end = index;
            else
                begin = index + 1;
        }
        return begin;
    }
}

