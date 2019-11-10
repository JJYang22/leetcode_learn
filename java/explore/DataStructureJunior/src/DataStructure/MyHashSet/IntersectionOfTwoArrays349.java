package DataStructure.MyHashSet;

import java.util.*;

/**
 * @Author Voidmian
 * @Date 2019/11/7 16:03
 */
public class IntersectionOfTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int [] num1,num2;
        if(nums1.length<nums2.length){
            num1=nums1;
            num2=nums2;
        }else{
            num1=nums2;
            num2=nums1;
        }
        Set<Integer> used = new HashSet<>();
        Set<Integer> list = new HashSet<>();
        for (int num: num1) {
            used.add(num);
        }
        for(int num:num2){
            if(used.contains(num))
                list.add(num);
        }
        int [] ans= new int [list.size()];
        Iterator <Integer>iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            ans[i]=iterator.next();
        }
        return ans;
    }

}
