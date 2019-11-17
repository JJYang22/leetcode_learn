package DataStructure.MyBinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Voidmian
 * @Date 2019/11/14 21:59
 */
public class FindKClosestElements658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

            int length = arr.length;
            int left = 0;
            int right = length - k;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if(Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            List<Integer> result = new ArrayList();
            for (int i = 0; i < k; i++) {
                result.add(arr[left + i]);
            }
            return result;

//        if (arr == null || arr.length == 0)
//            return new ArrayList<>();
//        List<Integer> ans =new ArrayList<>();
//        int left = 0, right = arr.length - 1;
//        int mid = left + (right - left) / 2;
//        int index = -1;
//        while (left <= right) {
//            if(left == right) {
//                index = mid;
//                break;
//            }
//            if (arr[mid] == x) {
//                index = mid;
//                break;
//            } else if (arr[mid] < x) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//            mid = left + (right - left) / 2;
//        }
//        if (index != 0 && arr[index - 1] - x < arr [index] -x){
//            index--;
//        }
//        ans.add(arr[index]);
//        k--;
//        int temp1 = index + 1;
//        int temp2 = index - 1;
//        while (k>0){
//            if(temp2 < 0){
//                ans.add(arr[temp1]);
//                temp1++;
//                k--;
//            }
//            if(temp1 >= arr.length){
//                ans.add(0,arr[temp2]);
//                temp2--;
//                k--;
//            }
//            if( temp2 >= 0 && temp1 < arr.length){
//                if(arr[temp1] - x < x - arr[temp2]){
//                    ans.add(arr[temp1]);
//                    temp1++;
//                    k--;
//                } else {
//                    ans.add(0,arr[temp2]);
//                    temp2--;
//                    k--;
//                }
//            }
//        }
//        return ans;
    }
}
