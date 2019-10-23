package Array;

/**
 * @Author Voidmian
 * @Date 2019/10/23 14:40
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class RotateArray {
    static public void test(){
        int [] nums={1,2,3,4,5,6,7,8};
        int k=3;
        RotateArray rotateArray=new RotateArray();
        rotateArray.rotateByReverse(nums,k);
        for (int num:nums
             ) {
            System.out.println(num);
        }


    }

    public void rotateByReverse(int [] nums,int k){
        k%=nums.length;
        ReverseArray.reverseIntArray(nums,0,nums.length);
        ReverseArray.reverseIntArray(nums,0,k);
        ReverseArray.reverseIntArray(nums,k,nums.length);
    }


    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int start=0;
        int current=0;
        int preNum=nums[current];
        for (int count = 0; count <nums.length ; count++) {
            if (count !=0 &&current == start) {
                start++;
                current++;
                preNum=nums[current];
            }
            current = (current + k)%nums.length;
            int temp=nums[current];
            nums[current]=preNum;
            preNum=temp;
        }
    }
}
