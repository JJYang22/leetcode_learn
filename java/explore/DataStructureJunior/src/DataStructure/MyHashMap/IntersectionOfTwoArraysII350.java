package DataStructure.MyHashMap;

import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author Voidmian
 * @Date 2019/11/8 15:37
 */
public class IntersectionOfTwoArraysII350 {
    static public void test(){
        IntersectionOfTwoArraysII350 intersectionOfTwoArraysII350=new IntersectionOfTwoArraysII350();
        int [] nums1={4,9,5};
        int [] nums2={9,4,9,8,4};
        intersectionOfTwoArraysII350.intersect(nums1,nums2);
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int [0];
        }
        int[] numShort;
        int[] numLong;
        if (nums1.length < nums2.length) {
            numShort = nums1;
            numLong = nums2;
        } else {
            numShort = nums2;
            numLong = nums1;
        }
        List<Integer> listAns = new LinkedList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numShort.length; i++) {
            map.put(numShort[i], map.getOrDefault(numShort[i],0 ) + 1);
        }
        for (int i = 0; i < numLong.length; i++) {
            if (map.containsKey(numLong[i])) {
                int temp = map.get(numLong[i]);
                if (temp == 1)
                    map.remove(numLong[i]);
                else
                    map.put(numLong[i], temp - 1);
                listAns.add(numLong[i]);
            }
        }
        int[] ans = new int[listAns.size()];
        for (int i = 0; i < listAns.size(); i++) {
            ans[i] = listAns.get(i);
        }
        return ans;
    }
}
