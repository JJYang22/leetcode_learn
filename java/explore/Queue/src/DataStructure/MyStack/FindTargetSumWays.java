package DataStructure.MyStack;

/**
 * @Author Voidmian
 * @Date 2019/10/29 19:28
 */
public class FindTargetSumWays {
    static public void test(){
        int [] nums= {1,1,1,1,1};
        int S=3;
        FindTargetSumWays findTargetSumWays= new FindTargetSumWays();
        System.out.println(findTargetSumWays.findTargetSumWays(nums,S) );
    }
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null)
            return 0;
        int temp=nums[0];
        return fun(nums,S,0,temp)+fun(nums,S,0,-1*temp);
    }
    private int fun(int [] nums,int S,int index,int temp){
        index++;
        if(index == nums.length ){
            if(temp == S)
                return 1;
            else
                return 0;
        }
        return fun(nums,S,index,temp-nums[index]) + fun(nums,S,index,temp+nums[index]);
    }

}
