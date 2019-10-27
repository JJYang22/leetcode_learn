package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;

/**
 * @Author Voidmian
 * @Date 2019/10/25 9:44
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    static public void test(){
        PlusOne plusOne=new PlusOne();
        int [] nums ={9,9,8,9};
        int [] ans=plusOne.plusOne(nums);
        for (int a:ans
        ) {
            System.out.println(a);
        }
    }

    public int[] plusOne(int[] digits) {

        int temp=digits.length-1;
        while (temp > 0 && digits[temp] == 9) {
            temp--;
        }
        if(temp == 0 && digits[temp]==9){
            int [] ans=new int[digits.length+1];
            ans[0]=1;
            return ans;
        }
        if(temp == digits.length-1){
            digits[temp]+=1;
            return digits;
        }


        digits[temp]+=1;
        for(int i=temp+1;i<digits.length;i++){
            digits[i]=0;
        }
        return digits;

    }

}
