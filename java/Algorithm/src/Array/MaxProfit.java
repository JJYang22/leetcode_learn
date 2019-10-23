package Array;

/**
 * @Author Voidmian
 * @Date 2019/10/15 19:20
 */

public class MaxProfit {
    static public void test(){
        MaxProfit s= new MaxProfit();
        int [] nums ={7,1,5,3,6,4};
        System.out.println(s.maxProfit(nums));
    }

    public int maxProfit(int[] prices) {
        int profit=0;
        for (int i = 0; i <prices.length-1 ; i++) {
            if(prices[i]<prices[i+1]){
                profit+=prices[i+1]-prices[i];
            }
        }
        return profit;
    }
}