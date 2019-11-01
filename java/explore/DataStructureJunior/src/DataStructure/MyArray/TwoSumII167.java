package DataStructure.MyArray;

/**
 * @Author Voidmian
 * @Date 2019/11/1 12:12
 */
public class TwoSumII167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = {0, numbers.length - 1};
        while (numbers[ans[0]] + numbers[ans[1]] != target || ans[0]==ans[1]){
            if(numbers[ans[0]] + numbers[ans[1]]>target)
                ans[1]-=1;
            else
                ans[0]+=1;
        }
        if(ans[0]==ans[1]){
            ans[0]=0;
            ans[1]=0;
        }else{
            ans[0]++;
            ans[1]++;
        }
        return ans;
    }
}
