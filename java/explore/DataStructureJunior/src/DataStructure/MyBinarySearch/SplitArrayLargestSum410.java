package DataStructure.MyBinarySearch;

import DataStructure.MyArray.SpiralOrder54;
import jdk.jshell.Snippet;

/**
 * @Author Voidmian
 * @Date 2019/11/17 13:31
 */
public class SplitArrayLargestSum410 {
    static public void test() {
        SplitArrayLargestSum410 splitArrayLargestSum410 = new SplitArrayLargestSum410();
        int[] nums = {7,2,5,10,8};
        System.out.println(splitArrayLargestSum410.splitArray(nums, 2));
    }

    public int splitArray(int[] nums, int m) {
        long begin = nums[0];
        long end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(begin < nums[i]){
                begin = nums[i];
            }
            end += nums[i];
        }
        while (begin < end) {
            long index = begin + (end - begin) / 2;
            int count = 1;
            long temp = 0;
            for (int i = 0; i < nums.length; i++) {
                if (temp + nums[i] > index) {
                    temp = nums[i];
                    count++;
                } else {
                    temp += nums[i];
                }
            }
            if (count <= m) {
                end = index;
            } else {
                begin = index + 1;
            }
        }
        return (int)begin;
//        long begin = nums[0];
//        long end = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            end += nums[i];
//        }
//        while (begin < end) {
//            long index = begin + (end - begin) / 2;
//            int count = 0;
//            long temp = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (count == m)
//                    break;
//                if (temp + nums[i] > index) {
//                    temp = nums[i];
//                    if(temp > index){
//                        count = m + 1;
//                    }
//                    count++;
//                } else {
//                    temp += nums[i];
//                }
//            }
//            count++;
//            if (count <= m) {
//                end = index;
//            } else {
//                begin = index + 1;
//            }
//        }
//        return (int)begin;
    }
}
