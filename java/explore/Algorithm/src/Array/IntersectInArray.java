package Array;

import java.util.*;
import java.util.stream.Collector;

/**
 * @Author Voidmian
 * @Date 2019/10/23 16:41
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class IntersectInArray {
    static public void test(){
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        IntersectInArray intersectInArray=new IntersectInArray();
        int [] ans=intersectInArray.intersect(nums1,nums2);
        for (int a:ans
             ) {
            System.out.println(a);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans =new ArrayList<>();
        if (nums1.length>nums2.length){
            int [] num=nums2;
            nums2=nums1;
            nums1=num;
        }
        for (int num1 : nums1) {
            map.put(num1, map.getOrDefault(num1, 0) + 1);
        }
        for (int num2 : nums2) {
            if (map.containsKey(num2) && map.get(num2) > 0) {
                ans.add(num2);
                map.put(num2,map.get(num2)-1);
            }
        }
        int [] ansInt=new int[ans.size()];
        for (int i = 0; i <ans.size() ; i++) {
            ansInt[i]=ans.get(i);
        }
        return ansInt;
    }
}
