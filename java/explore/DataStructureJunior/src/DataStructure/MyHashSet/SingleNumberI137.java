package DataStructure.MyHashSet;

/**
 * @Author Voidmian
 * @Date 2019/11/6 20:28
 */
public class SingleNumberI137 {
    public int singleNumber(int[] nums) {

        int one=0;
        int two=0;

        for (int i = 0; i < nums.length ; i++) {
            one = one ^ (~two) & (nums[i]);
            two = two ^ (~one) & (nums[i]);
        }

        return one;
    }
//    public int singleNumber(int[] nums) {
//
//        int one1=0;
//        int two1=0;
//        int one2=0;
//        int two2=0;
//        for (int i = 0; i < nums.length ; i++) {
//            one2=~nums[i]&one1&~two1 | nums[i]&~one1&~two1 ;  //   one2=(nums[i]^one1)&~two1 ;
//            two2=nums[i]&one1&~two1 | ~nums[i]&~one1&two1;
//            one1=one2;
//            two1=two2;
//        }
//        return one1;
//    }

}
